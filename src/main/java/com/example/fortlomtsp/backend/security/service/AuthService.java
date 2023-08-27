package com.example.fortlomtsp.backend.security.service;

import com.example.fortlomtsp.backend.domain.model.entity.*;
import com.example.fortlomtsp.backend.domain.model.enumeration.Rolname;
import com.example.fortlomtsp.backend.domain.service.*;
import com.example.fortlomtsp.backend.security.Dto.*;
import com.example.fortlomtsp.backend.security.jwt.jwtProvider;
import com.example.fortlomtsp.shared.exception.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    FanaticService fanaticService;

    @Autowired
    AdminService adminService;

    @Autowired
    ArtistService artistService;

    @Autowired
    jwtProvider jwtProvider;

    @Autowired
    RolService rolService;

    @Autowired
    UserAccountService userAccountService;



    public Rol getrolefanatic() throws Message {

        Optional<Rol>value=rolService.findByName(Rolname.Role_Fanatic);
        if(value.isPresent()){
            return value.get();
        }
        throw new Message("Error");
    }

    public Rol getroleartist() throws Message {

        Optional<Rol>value=rolService.findByName(Rolname.Role_Artist);
        if(value.isPresent()){
            return value.get();
        }
        throw new Message("Error");
    }

    public Rol getroleadmin() throws Message {

        Optional<Rol>value=rolService.findByName(Rolname.Role_Admin);
        if(value.isPresent()){
            return value.get();
        }
        throw new Message("Error");
    }


    public ResponseEntity<?> registerfanatic(NewFanatic request, BindingResult bindingResult) throws Message {
        if (bindingResult.hasErrors()){


            return new ResponseEntity(new Message("campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(fanaticService.existsByUsername(request.getUsername())){
            return new ResponseEntity(new Message("ya existe nombre"), HttpStatus.BAD_REQUEST);

        }
        if (fanaticService.existsByEmail(request.getEmail())){
            return new ResponseEntity(new Message("ya existe email"), HttpStatus.BAD_REQUEST);
        }
        Fanatic fanatic= new Fanatic();
        fanatic.setUsername(request.getUsername());
        fanatic.setRealname(request.getRealname());
        fanatic.setLastname(request.getLastname());
        fanatic.setEmail(request.getEmail());
        fanatic.setFanaticalias(request.getFanaticalias());
        fanatic.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(getrolefanatic());
        fanatic.setRoles(roles);
        fanaticService.save(fanatic);
        return new ResponseEntity(new Message("new fanatic saved"),HttpStatus.CREATED);

    }
    public ResponseEntity<?> registerartist(NewArtist request, BindingResult bindingResult) throws Message {
        if (bindingResult.hasErrors()){


            return new ResponseEntity(new Message("campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        }
        if(artistService.existsByUsername(request.getUsername())){
            return new ResponseEntity(new Message("ya existe nombre"), HttpStatus.BAD_REQUEST);

        }
        if (artistService.existsByEmail(request.getEmail())){
            return new ResponseEntity(new Message("ya existe email"), HttpStatus.BAD_REQUEST);
        }
        Artist artist= new Artist();
        artist.setUsername(request.getUsername());
        artist.setRealname(request.getRealname());
        artist.setLastname(request.getLastname());
        artist.setEmail(request.getEmail());
        artist.setArtistfollowers((long)0 );
        artist.setPassword(passwordEncoder.encode(request.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(getroleartist());
        artist.setRoles(roles);
        artistService.save(artist);
        return new ResponseEntity(new Message("new artist saved"),HttpStatus.CREATED);

    }
    public ResponseEntity<?> registeradmin(RegisterUser registerUser, BindingResult bindingResult) throws Message {

        Admin userAccount = new Admin();
        userAccount.setUsername(registerUser.getUsername());
        userAccount.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        userAccount.setRealname(registerUser.getRealname());
        userAccount.setLastname(registerUser.getLastname());
        userAccount.setEmail(registerUser.getEmail());
        Set<Rol> roles = new HashSet<>();
        roles.add(getroleadmin());
        userAccount.setRoles(roles);
        adminService.save(userAccount);
        return new ResponseEntity(new Message("admin"),HttpStatus.CREATED);
    }


    public ResponseEntity<jwtDto>login(LoginUser loginUser, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNombreUsuario(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        jwtDto jwtDto = new jwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);






    }
}

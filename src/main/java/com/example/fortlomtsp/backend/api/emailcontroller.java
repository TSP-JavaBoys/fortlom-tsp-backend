package com.example.fortlomtsp.backend.api;


import com.example.fortlomtsp.backend.security.Dto.ChangePassword;
import com.example.fortlomtsp.backend.security.Dto.EmailValues;
import com.example.fortlomtsp.backend.security.service.EmailService;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/email-password")
@CrossOrigin(origins = {"*"})
public class emailcontroller {

    @Autowired
    EmailService emailService;

    @ApiOperation(value="sendEmailTemplate",notes = "Esta consulta nos ayuda a enviar un email al usuario")
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValues dto) {
        return emailService.sendEmailTemplate(dto);
    }
    @ApiOperation(value="changePassword",notes = "Esta consulta nos ayuda a cambiar la contraseña de seguridad")
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePassword dto, BindingResult bindingResult) {

        return emailService.changePassword(dto, bindingResult);



    }
}

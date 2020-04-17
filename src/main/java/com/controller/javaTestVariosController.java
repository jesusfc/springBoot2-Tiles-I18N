package com.controller;

import com.constant.ViewConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Controller
public class javaTestVariosController extends CommonController {

    private static Logger log = LogManager.getLogger(javaTestVariosController.class);

    @RequestMapping(value = "/" + ViewConstants.JAVA_VARIOS_TEST, method = RequestMethod.GET)
    public ModelAndView goToJavaVariosTestView() {

        ModelAndView modelAndView = new ModelAndView(ViewConstants.JAVA_VARIOS_TEST, "view", ViewConstants.JAVA_VARIOS_TEST);
        try {
            User user = new User();
            user.setNombre("Jesús");
            user.setApellido("Fernández");
            user.setEmail("email con ñ");

            modelAndView.addObject("user", user);
            modelAndView.addObject("encodeUser", encodeUser(user));


            System.out.println("javaTestVariosController.java - JAVA_VARIOS_TEST");

        } catch (Exception e) {
            log.error("Error en goToJavaVariosTestView: ", e);
        }

        return modelAndView;

    }

    @RequestMapping(value = "/" + ViewConstants.JAVA_VARIOS_TEST, method = RequestMethod.POST)
    public @ResponseBody Boolean getUserDecodeInfo(final @RequestParam(value = "json") String json) {

        try {

            User user = decodeUser(json);
            System.out.println(user.toString());

        } catch (Exception e) {
            log.error("Error en getUserDecodeInfo: ", e);
        }

        return true;
    }



    /**
     * Transforma el objeto user en un string codificado para enviarlo al frontal
     */
    protected String encodeUser(User user) throws JsonProcessingException, UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(getMapper().writeValueAsString(user).getBytes(StandardCharsets.ISO_8859_1));
    }

    /**
     * Transforma un string codificado del frontal en un objeto User
     */
    protected User decodeUser(String json) throws IOException {
        return getMapper().readValue(new String(Base64.getDecoder().decode(json), StandardCharsets.ISO_8859_1), User.class);
    }

}




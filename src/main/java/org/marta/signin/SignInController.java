package org.marta.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by marta on 27.10.15.
 */
@Controller
public class SignInController
{
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signInForm()
    {
        return "signin/signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signInSubmit()
    {
        return "home/home";
    }
}

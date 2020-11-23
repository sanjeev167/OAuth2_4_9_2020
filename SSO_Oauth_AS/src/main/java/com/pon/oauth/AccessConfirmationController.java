/**
 * 
 */
package com.pon.oauth;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author Sanjeev
 *
 */
@Controller
@SessionAttributes(types = AuthorizationRequest.class)
public class AccessConfirmationController {

  private ClientDetailsService clientDetailsService;

  @RequestMapping("/oauth/confirm_access")
  public ModelAndView getAccessConfirmation(@ModelAttribute AuthorizationRequest clientAuth) throws Exception {
	 System.out.println("Registered client = "+clientAuth.getClientId());
    ClientDetails client = clientDetailsService.loadClientByClientId(clientAuth.getClientId());
    TreeMap<String, Object> model = new TreeMap<String, Object>();
    SecurityContextHolder contextHolder=new SecurityContextHolder();
    
    
    model.put("auth_request", clientAuth);
   // System.out.println("clientId  = "+client.getClientId());
   // System.out.println("ClientSecret  = "+client.getClientSecret());
    //System.out.println("Allowed Scope  = "+client.getScope());
    //System.out.println("clientAuth  = "+client.getRegisteredRedirectUri());
    //System.out.println("clientAuth  = "+client.getAuthorizedGrantTypes());
    System.out.println("### Following Scopes have been registerd with SSO for "+client.getClientId()+" ###");
    client.getScope().forEach(scope->{    	
    	System.out.println("Scope => "+scope);
    });; 
    
    model.put("client", client);  
    model.put("logedInUser", contextHolder.getContext().getAuthentication().getName());
    return new ModelAndView("access_confirmation", model);
  }

  @Autowired
  public void setClientDetailsService(ClientDetailsService clientDetailsService) {
    this.clientDetailsService = clientDetailsService;
  }
}
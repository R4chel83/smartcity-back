package mx.infotec.smartcity.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.infotec.smartcity.backend.model.Role;
import mx.infotec.smartcity.backend.service.AdminUtilsService;
import mx.infotec.smartcity.backend.service.LoginService;
import mx.infotec.smartcity.backend.service.RoleService;
import mx.infotec.smartcity.backend.service.UserService;
import mx.infotec.smartcity.backend.service.keystone.pojo.changePassword.ChangeUserPassword;
import mx.infotec.smartcity.backend.service.keystone.pojo.createUser.CreateUser;
import mx.infotec.smartcity.backend.utils.RoleUtil;


/**
 *
 * @author Benjamin Vander Stichelen
 */
@RestController
@RequestMapping("/users")
public class UserController {


  private static final Logger LOGGER                            =
      LoggerFactory.getLogger(UserController.class);


  @Autowired
  @Qualifier("keystoneUserService")
  private UserService         userService;

  @Autowired
  @Qualifier("keystoneRoleService")
  private RoleService         roleService;
  @Autowired
  @Qualifier("keystoneLoginService")
  private LoginService        loginService;

  @Autowired
  private AdminUtilsService   adminUtils;

  private String              END_USER                          = "End User";
  private String              ADMINISTRATOR                     = "Administrator";
  private String              ADMINISTRATOR_OF_PUBLIC_TRANSPORT =
      "Administrator of public transport";


  @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> getUsers(@RequestHeader(value = "token-auth") String token) {
    try {
      return ResponseEntity.accepted().body(userService.getAllUsers(token));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }


  @RequestMapping(method = RequestMethod.POST, value = "/role/{role}",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> createUsersWithDefaultRole(
      @RequestHeader(value = "token-auth") String token, @RequestBody CreateUser user,
      @PathVariable("role") String role) {
    try {


      // createdUser.getUser().getId(), token);
      // return ResponseEntity.accepted().body(createdUser);
      Role roleEnum = RoleUtil.validateRole(role);
      if (roleEnum == null) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("The role of the user is incorrect");
      }
      return ResponseEntity.accepted().body(userService.createUserWithRole(user, roleEnum));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }



  @RequestMapping(method = RequestMethod.POST, value = "/{userid}/password",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> changeUserPassword(@PathVariable("userid") String userid,
      @RequestHeader(value = "token-auth") String token, @RequestBody ChangeUserPassword user) {
    try {

      // return ResponseEntity.accepted().body(user);
      return ResponseEntity.accepted().body(userService.changePassword(userid, user, token));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.PATCH, value = "/{userid}",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> updateUser(@PathVariable("userid") String userid,
      @RequestHeader(value = "token-auth") String token, @RequestBody CreateUser user) {
    try {

      // return ResponseEntity.accepted().body(user);
      return ResponseEntity.accepted().body(userService.updateUser(userid, token, user));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{userid}",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> getUser(@PathVariable("userid") String userid,
      @RequestHeader(value = "token-auth") String token) {
    try {

      // return ResponseEntity.accepted().body(user);
      return ResponseEntity.accepted().body(userService.getUser(userid, token));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{username}/byUsername",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username,
      @RequestHeader(value = "token-auth") String token) {
    try {

      // return ResponseEntity.accepted().body(user);
      return ResponseEntity.accepted().body(userService.getUserByUsername(username, token));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }


  @RequestMapping(method = RequestMethod.GET, value = "/{name}/byName",
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> getUserByName(@PathVariable("name") String name,
      @RequestHeader(value = "token-auth") String token) {
    try {

      // return ResponseEntity.accepted().body(user);
      return ResponseEntity.accepted().body(userService.getUserByName(name, token));
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }
  // TODO Check if token will be validate from front
  /*
   * @RequestMapping(method = RequestMethod.GET, value = "/token/{authToken}", consumes =
   * MediaType.APPLICATION_JSON_UTF8_VALUE) public ResponseEntity<?>
   * getUserFromToken(@PathVariable("authToken") String authToken,
   * 
   * @RequestHeader(value = "token-auth") String tokenAdmin) { try {
   * 
   * // return ResponseEntity.accepted().body(user); return
   * ResponseEntity.accepted().body(userService.getUserFromToken(tokenAdmin, authToken)); } catch
   * (Exception ex) { return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage()); }
   * }
   */


  // @RequestMapping(method = RequestMethod.GET, value = "/token/{authToken}")
  // public ResponseEntity<?> getUserFromToken(@PathVariable("authToken") String authToken) {
  // try {
  // String tokenAdmin = adminUtils.getAdmintoken();
  // // return ResponseEntity.accepted().body(user); return
  // ResponseEntity<?> response = ResponseEntity.accepted()
  // .body(userService.getUserFromTokenToIdentityUser(tokenAdmin, authToken));
  // loginService.invalidToken(tokenAdmin);
  //
  // return response;
  // } catch (Exception ex) {
  // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
  // }
  // }

}

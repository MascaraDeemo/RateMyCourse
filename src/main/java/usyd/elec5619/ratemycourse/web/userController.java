/*package usyd.elec5619.ratemycourse.web;


import java.util.ArrayList;
import java.util.List;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fkit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
@Controller
@RequestMapping(value="user")
public class userController {
	//静态List<User>集合，此处代替数据库用来保存注册的用户信息
	private static List<User> userList;
	//UserController类的构造器，初始化List<User>集合
	public userController(){
		super();
		userList = new ArrayList<User>();
	}
	//静态日之类loggerMaggent
	private static final Logger logger = LogManager.getLogger(UserController.class.getName());
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm(){
		logger.info("register GET 方法被调用……");
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(@RequestParam("loginname")String loginname,
			@RequestParam("password")String password,
			@RequestParam("username")String username){
		logger.info("register POST 方法被调用……");
		//创建user对象
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		//模拟数据库存储User信息
		userList.add(user);
		return "loginForm";		
	}
	
	//登录
	@RequestMapping("/login")
	public String login(@RequestParam("loginname")String loginname,
			@RequestParam("password")String password,Model model){
		logger.info("登录名："+loginname+" 密码："+password);
		//到集合中查找用户是否存在，此处用来模拟数据库验证
		for(User user:userList){
			if(user.getLoginname().equals(loginname) && user.getPassword().equals(password)){
				model.addAttribute("user", user);
				return "welcome";
			}
		}
		return "loginForm";
	}
	
}
*/
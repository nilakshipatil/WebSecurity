package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableWebSecurity(debug=true)
public class WebsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsecurityApplication.class, args);
	}
	
	@Component
	public class LoginConfigurer extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity hhtp)throws Exception{
			hhtp.antMatcher("/admin/**").authorizeRequests().anyRequest().authenticated()
			.and().logout().logoutUrl("/my/logout").permitAll().logoutSuccessUrl("/")
			.and().httpBasic();   //.and().formLogin();
			
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth)throws Exception{
			auth.inMemoryAuthentication().withUser("nilakshi").password("nilakshi").roles("user");
		}
	}	
}
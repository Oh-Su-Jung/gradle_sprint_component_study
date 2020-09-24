package gradle_sprint_component_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_sprint_component_study.spring.ChangePasswordService;
import gradle_sprint_component_study.spring.MemberDao;
import gradle_sprint_component_study.spring.MemberInfoPrinter;
import gradle_sprint_component_study.spring.MemberListPrinter;
import gradle_sprint_component_study.spring.MemberPrinter;
import gradle_sprint_component_study.spring.MemberRegisterService;
import gradle_sprint_component_study.spring.MemberSummaryPrinter;
import gradle_sprint_component_study.spring.VersionPrinter;

@Configuration
public class AppCtx {
	@Bean
	public MemberDao MemberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService MemberRegSvc() {
		return new MemberRegisterService();
	}

	@Bean
	public ChangePasswordService ChangePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(/*MemberDao(), memberPrinter()*/);
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}

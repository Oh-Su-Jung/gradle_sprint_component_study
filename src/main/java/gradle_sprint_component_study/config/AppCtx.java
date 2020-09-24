package gradle_sprint_component_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import gradle_sprint_component_study.spring.ChangePasswordService;
import gradle_sprint_component_study.spring.MemberDao;
import gradle_sprint_component_study.spring.MemberInfoPrinter;
import gradle_sprint_component_study.spring.MemberListPrinter;
import gradle_sprint_component_study.spring.MemberPrinter;
import gradle_sprint_component_study.spring.MemberRegisterService;
import gradle_sprint_component_study.spring.MemberSummaryPrinter;
import gradle_sprint_component_study.spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"gradle_sprint_component_study.spring"})
public class AppCtx {
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
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}

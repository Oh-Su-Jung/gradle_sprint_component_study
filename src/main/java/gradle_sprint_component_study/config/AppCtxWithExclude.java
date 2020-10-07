package gradle_sprint_component_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import gradle_sprint_component_study.spring.MemberPrinter;
import gradle_sprint_component_study.spring.MemberSummaryPrinter;
import gradle_sprint_component_study.spring.VersionPrinter;

@Configuration
/*@ComponentScan(basePackages = {"gradle_sprint_component_study.spring"},
	excludeFilters = @Filter(type = FilterType.REGEX, pattern = "gradle_sprint_component_study.spring\\..Dao")
)*/
@ComponentScan(basePackages = {"gradle_sprint_component_study.spring"},
excludeFilters = @Filter(type = FilterType.ASPECTJ, pattern = "gradle_sprint_component_study.spring.*Dao")
)
public class AppCtxWithExclude {
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

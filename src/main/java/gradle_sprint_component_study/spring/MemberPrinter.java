package gradle_sprint_component_study.spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}

	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());	
		} else {
			System.out.printf("회원 정보 : 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	
	@Autowired
	public void setDateTimeformatter(Optional<DateTimeFormatter> dateTimeformatter) {
		//this.dateTimeFormatter = dateTimeformatter;
		if (dateTimeformatter.isPresent()) {
			this.dateTimeFormatter = dateTimeformatter.get();
		} else {
			this.dateTimeFormatter = null;
		}

	}
}

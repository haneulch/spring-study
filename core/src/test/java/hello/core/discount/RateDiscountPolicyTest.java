package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP�� 10% ������ ����Ǿ�� �Ѵ�")
	void vip_o() {
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP�� �ƴϸ� ���� ������� �ʾƾ� �Ѵ�")
	void vip_x() {
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(0);
	}
}
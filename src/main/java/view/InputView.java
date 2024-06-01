package view;

import card.controller.DrawCardRequest;
import participant.controller.ParticipantRequest;
import participant.model.Participant;
import utils.Console;

public class InputView {
	public ParticipantRequest inputParticipants() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
		try {
			return ParticipantRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputParticipants();
		}
	}

	public DrawCardRequest inputDrawCard(final Participant participant) {
		System.out.println("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)".formatted(participant.getName()));
		try {
			return DrawCardRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputDrawCard(participant);
		}
	}
}

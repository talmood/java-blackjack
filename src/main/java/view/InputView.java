package view;

import participant.controller.ParticipantRequest;
import utils.Console;

public class InputView {
	public static ParticipantRequest inputParticipants() {
		System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
		try {
			return ParticipantRequest.from(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputParticipants();
		}
	}
}

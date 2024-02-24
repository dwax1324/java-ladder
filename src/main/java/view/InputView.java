package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {

    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return parseByDelimiter(SCANNER.nextLine());
    }

    public static List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return parseByDelimiter(SCANNER.nextLine());
    }

    private static List<String> parseByDelimiter(String input) {
        validateDelimiter(input);

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private static void validateDelimiter(final String userNames) {
        if (userNames.startsWith(",")) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 구분자로 시작할 수 없습니다.", userNames));
        }
        if (userNames.endsWith(",")) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 구분자로 끝날 수 없습니다.", userNames));
        }
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String rawHeight = SCANNER.nextLine();
        validateHeight(rawHeight);
        return Integer.parseInt(rawHeight);
    }


    private static void validateHeight(String height) {
        if (isNumeric(height)) {
            throw new IllegalArgumentException(String.format("입력된 값: %s, 숫자를 입력해주세요.", height));
        }
    }

    private static boolean isNumeric(String input) {
        return !input.matches("-?\\d+");
    }

}

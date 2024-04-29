public class Game {
    public String question;

    public GueseResult guess(String guessNumber) {
        assertIllegalArgument(guessNumber);
        if (guessNumber.equals(question)) return new GueseResult(true, 3, 0);
        if (isNoSameNumber(guessNumber)) return new GueseResult(false, 0, 0);
        return calcGuessResult(guessNumber);
    }

    private GueseResult calcGuessResult(String guessNumber) {
        int strikes = 0;
        int ball = 0;
        for (int i = 0; i < question.length(); i++) {
            char chartAt = guessNumber.charAt(i);
            int indexOf = question.indexOf(chartAt);
            if (indexOf == i) strikes++;
            else if (indexOf != -1) ball++;
        }
        return new GueseResult(false, strikes, ball);
    }

    private void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null || guessNumber.length() != 3) {
            throw new IllegalArgumentException("입력값은 3개 숫자여야합니다.");
        }
        if (!guessNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("입력값은 숫자만 가능합니다.");
        }
        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException("중복된 숫자가 입력될 수 없습니다.");
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }

    private boolean isNoSameNumber(String inputNum) {
        for (int i = 0; i < inputNum.length(); i++) {
            if (question.indexOf(inputNum.charAt(i)) != -1) {
                return false;
            }
        }
        return true;
    }
}

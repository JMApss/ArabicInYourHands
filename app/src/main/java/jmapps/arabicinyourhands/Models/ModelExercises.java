package jmapps.arabicinyourhands.Models;

public class ModelExercises {

    private final String exercisesIdPosition;
    private final String exercisesTitle;
    private final String exercisesTitleContent;
    private final String questionTextOne;
    private final String questionAudioFileNameOne;
    private final String answerTextTwo;
    private final String answerAudioFileNameTwo;
    private final String questionTextThree;
    private final String questionAudioFileNameThree;
    private final String answerTextFour;
    private final String answerAudioFileNameFour;
    private final String questionTextFive;
    private final String questionAudioFileNameFive;
    private final String answerTextSix;
    private final String answerAudioFileNameSix;
    private boolean isQuestionShowing = false;
    private boolean isAnswerShowing = false;

    public ModelExercises(String exercisesIdPosition,
                          String exercisesTitle,
                          String exercisesTitleContent,
                          String questionTextOne,
                          String questionAudioFileNameOne,
                          String answerTextTwo,
                          String answerAudioFileNameTwo,
                          String questionTextThree,
                          String questionAudioFileNameThree,
                          String answerTextFour,
                          String answerAudioFileNameFour,
                          String questionTextFive,
                          String questionAudioFileNameFive,
                          String answerTextSix,
                          String answerAudioFileNameSix
    ) {
        this.exercisesIdPosition = exercisesIdPosition;
        this.exercisesTitle = exercisesTitle;
        this.exercisesTitleContent = exercisesTitleContent;
        this.questionTextOne = questionTextOne;
        this.questionAudioFileNameOne = questionAudioFileNameOne;
        this.answerTextTwo = answerTextTwo;
        this.answerAudioFileNameTwo = answerAudioFileNameTwo;
        this.questionTextThree = questionTextThree;
        this.questionAudioFileNameThree = questionAudioFileNameThree;
        this.answerTextFour = answerTextFour;
        this.answerAudioFileNameFour = answerAudioFileNameFour;
        this.questionTextFive = questionTextFive;
        this.questionAudioFileNameFive = questionAudioFileNameFive;
        this.answerTextSix = answerTextSix;
        this.answerAudioFileNameSix = answerAudioFileNameSix;
    }

    public String getExercisesIdPosition() {
        return exercisesIdPosition;
    }

    public String getExercisesTitle() {
        return exercisesTitle;
    }

    public String getExercisesTitleContent() {
        return exercisesTitleContent;
    }

    public String getQuestionTextOne() {
        return questionTextOne;
    }

    public String getQuestionAudioFileNameOne() {
        return questionAudioFileNameOne;
    }

    public String getAnswerTextTwo() {
        return answerTextTwo;
    }

    public String getAnswerAudioFileNameTwo() {
        return answerAudioFileNameTwo;
    }

    public String getQuestionTextThree() {
        return questionTextThree;
    }

    public String getQuestionAudioFileNameThree() {
        return questionAudioFileNameThree;
    }

    public String getAnswerTextFour() {
        return answerTextFour;
    }

    public String getAnswerAudioFileNameFour() {
        return answerAudioFileNameFour;
    }

    public String getQuestionTextFive() {
        return questionTextFive;
    }

    public String getQuestionAudioFileNameFive() {
        return questionAudioFileNameFive;
    }

    public String getAnswerTextSix() {
        return answerTextSix;
    }

    public String getAnswerAudioFileNameSix() {
        return answerAudioFileNameSix;
    }

    public boolean isQuestionShowing() {
        return isQuestionShowing;
    }

    public void setQuestionShowing(boolean questionShowing) {
        isQuestionShowing = questionShowing;
    }

    public boolean isAnswerShowing() {
        return isAnswerShowing;
    }

    public void setAnswerShowing(boolean answerShowing) {
        isAnswerShowing = answerShowing;
    }

}

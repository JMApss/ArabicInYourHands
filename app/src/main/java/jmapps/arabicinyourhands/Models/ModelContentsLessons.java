package jmapps.arabicinyourhands.Models;

public class ModelContentsLessons {

    private final String lessonsContentArabic;
    private final String lessonsContentRussian;
    private final String lessonsNameAudio;

    public ModelContentsLessons(String lessonsContentArabic,
                                String lessonsContentRussian,
                                String lessonsNameAudio) {

        this.lessonsContentArabic = lessonsContentArabic;
        this.lessonsContentRussian = lessonsContentRussian;
        this.lessonsNameAudio = lessonsNameAudio;
    }

    public String getLessonsContentArabic() {
        return lessonsContentArabic;
    }

    public String getLessonsContentRussian() {
        return lessonsContentRussian;
    }

    public String getLessonsNameAudio() {
        return lessonsNameAudio;
    }
}

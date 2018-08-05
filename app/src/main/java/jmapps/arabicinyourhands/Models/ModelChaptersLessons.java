package jmapps.arabicinyourhands.Models;

public class ModelChaptersLessons {

    private final String titleChapter;
    private final String pathIcon;
    private final String setContentForChapter;

    public ModelChaptersLessons(String titleChapter, String pathIcon, String setContentForChapter) {
        this.titleChapter = titleChapter;
        this.pathIcon = pathIcon;
        this.setContentForChapter = setContentForChapter;
    }

    public String getTitleChapter() {
        return titleChapter;
    }

    public String getPathIcon() {
        return pathIcon;
    }

    public String getSetContentForChapter() {
        return setContentForChapter;
    }
}

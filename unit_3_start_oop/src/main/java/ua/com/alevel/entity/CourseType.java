package ua.com.alevel.entity;

public enum CourseType {

//    JAVA, JAVA_SCRIPT, DEV_OPS
    JAVA("JAVA", new String[]{ "1", "2", "17"}),
    JAVA_SCRIPT("JAVA SCRIPT", new String[]{ "2012", "2016", "2020"}),
    DEV_OPS("DEV OPS", new String[]{ "2012", "2016", "2020"});

    private final String name;
    private final String[] versions;

    CourseType(String name, String[] versions) {
        this.name = name;
        this.versions = versions;
    }

    public String getName() {
        return name;
    }

    public String[] getVersions() {
        return versions;
    }

    //    public String some;
//
//    public String getSome() {
//        return some;
//    }
//
//    public void setSome(String some) {
//        this.some = some;
//    }
//
//    public void add() {}
}

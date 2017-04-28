package EffectiveJavaImp.builderpackage;

/**
 * Created by panqiang on 2017/4/24.
 * 复杂多参数构造器方法，静态内部类
 */


public final class BuilderStruct {
    //employe
    private final String name;
    private final String englishname; //optional
    private final int age;
    private final String gender;
    private final String provine;//optional
    private final String city;//optional
    private final String tel;//optional
    private final float salary;//optional

    public String getName() {
        return name;
    }

    public String getEnglishname() {
        return englishname;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getProvine() {
        return provine;
    }

    public String getCity() {
        return city;
    }

    public String getTel() {
        return tel;
    }

    public float getSalary() {
        return salary;
    }

    /*
        enclosing class可以访问inner class的private/protected成员，inner class也可以访问enclosing class的private/protected成员
         */
    private BuilderStruct(Builder builder) {
        this.name = builder.name;
        this.englishname = builder.englishname;
        this.age = builder.age;
        this.gender = builder.gender;
        this.provine = builder.provine;
        this.city = builder.city;
        this.tel = builder.tel;
        this.salary = builder.salary;
    }

    public static class Builder {//其实很类似一个单独的类
        private String name;
        private String englishname = ""; //optional
        private int age;
        private String gender;
        private String provine="";
        private String city="";
        private String tel="";
        private float salary = 0f;//optional

        // 构造方法
        public Builder(String name, int age, String gen) {
            this.name = name;
            this.age = age;
            this.gender = gen;
        }

        public Builder setenglishname(String englishname) {
            this.englishname = englishname;
            return this;
        }

        public Builder setprovine(String provine) {
            this.provine = provine;
            return this;
        }

        public Builder setcity(String city) {
            this.city = city;
            return this;
        }

        public Builder settel(String tel) {
            this.tel = tel;
            return this;
        }

        public Builder setsalary(float salary) {
            this.salary = salary;
            return this;
        }

        // 在内部类中
        public BuilderStruct build() {
            return new BuilderStruct(this);
        }
    }


    @Override
    public String toString() {
        return "BuilderStruct{" +
                "name='" + name + '\'' +
                ", englishname='" + englishname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", provine='" + provine + '\'' +
                ", city='" + city + '\'' +
                ", tel='" + tel + '\'' +
                ", salary=" + salary +
                '}';
    }

}
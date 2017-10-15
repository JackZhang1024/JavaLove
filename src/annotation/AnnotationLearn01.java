package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by zfz on 2017/6/13.
 */
public class AnnotationLearn01 {

    public static void main(String[] args) {
        testBook();
    }


    public static void testBook(){
       Author author = Book.class.getAnnotation(Author.class);
       System.out.println(String.format("作者%s 出版社%s 出版日期%s", author.name(), author.press(),author.publish()));
       try{
           Field field = Book.class.getDeclaredField("preface");
           Preface preface =field.getAnnotation(Preface.class);
           System.out.println(preface.descriptions());

           Method languageMethod = Book.class.getDeclaredMethod("getLanguage");
           Method pageMethod = Book.class.getDeclaredMethod("getPages");
           Method commentMethod = Book.class.getDeclaredMethod("getComment",String.class);
           Method favoriteMarksMethod = Book.class.getDeclaredMethod("getFavoriteMarks",int.class);
           Method marketsMethod = Book.class.getDeclaredMethod("getMarkets");

           Language language = languageMethod.getAnnotation(Language.class);
           BooKPage booKPage = pageMethod.getAnnotation(BooKPage.class);
           Comment comment = commentMethod.getAnnotation(Comment.class);
           Marks marks = favoriteMarksMethod.getAnnotation(Marks.class);
           Markets markets = marketsMethod.getAnnotation(Markets.class);

           System.out.println(String.format("语言 %s", language.language()));
           System.out.println(String.format("页数 %s", booKPage.pages()));
           System.out.println(String.format("评价 %s", comment.comment()));
           System.out.println(String.format("喜欢的总数 %s", marks.marks()));

           for (Market market:markets.value()) {
                System.out.println(String.format("渠道 %s", market.market()));
           }

       }catch (NoSuchFieldException exception){
            exception.printStackTrace();
       }catch (NoSuchMethodException e){
            e.printStackTrace();
       }

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Author{
        String name();//姓名
        String press();//出版社
        String publish();//发布时间
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Language{
        String language();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface BooKPage{
        int pages();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Preface{
        String descriptions();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Comment{
         String comment();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Marks{
          int marks();
    }

    @Repeatable(Markets.class)
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Market{
        String market();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Markets{
        Market[] value();
    }

    @Author(name = "LiBai",press = "RenMingPress",publish = "20170613")
    public static class Book{

        @Preface(descriptions = "老鼠爱大米")
        private String preface;

        private Book(){

        }

        @Language(language = "日语")
        public String getLanguage(){
            return "English";
        }

        @BooKPage(pages = 240)
        public int getPages(){
            return 200;
        }

        @Comment(comment = "很好很好啊！！！")
        public String getComment(String comment){
            return comment;
        }

        @Marks(marks = 39)
        public int getFavoriteMarks(int marks){
            return marks;
        }

        @Markets({@Market(market = "京东"), @Market(market = "天猫"), @Market(market = "苏宁")})
        public String[] getMarkets(){
            return new String[]{"新华书店" , "京东" , "天猫", "当当"};
        }
    }


}

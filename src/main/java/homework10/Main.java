package homework10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        ServisLibraryMemory servisLibraryMemory =
                (ServisLibraryMemory) applicationContext.getBean("servisLibraryMemory");
        servisLibraryMemory.create(Book.builder()
                .id(1).name("Основы Безопасности Жизнедеятельности")
                .аuthor("Хренников").build());
        servisLibraryMemory.delete(2);
        servisLibraryMemory.update(Book.builder().id(2).name("Мария Стюарт").аuthor("Цвейг").build());


    }


}

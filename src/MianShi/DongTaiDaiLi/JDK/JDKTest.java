package MianShi.DongTaiDaiLi.JDK;

import MianShi.DongTaiDaiLi.CGLIB.BookFacadeImpl1;

public class JDKTest {
    public static void main(String[] args) {

        BookFacadeImpl1 bookFacadeImpl  = new BookFacadeImpl1();
        BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) bookFacadeProxy.bind(bookFacadeImpl);
        bookFacade.addBook();
    }
}

package MianShi.DongTaiDaiLi.JDK;


public class JDKTest {
    public static void main(String[] args) {

        BookFacadeImpl bookFacadeImpl  = new BookFacadeImpl();
        BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) bookFacadeProxy.bind(bookFacadeImpl);
        bookFacade.addBook();
    }
}

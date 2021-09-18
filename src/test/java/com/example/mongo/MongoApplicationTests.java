package com.example.mongo;

import com.example.mongo.entity.Book;
import com.example.mongo.repository.BookRepository;
import com.example.mongo.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@SpringBootTest
class MongoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    @Mock
    private List<String> mockList;

    @Spy
    private List<String> spyList = new ArrayList();

    @Test
    public void getBooksTest() {
        OngoingStubbing<List<Book>> listOngoingStubbing = when(bookRepository.findAll()).
                thenReturn(Stream.of(new Book(32, "WOF", "APJ"), new Book(5, "WOF",
                                "Rockey"), new Book(56, "XYZ", "RRR"))
                        .collect(Collectors.toList()));
        Assertions.assertEquals(3, bookService.findAll().size());
    }

    @Test
    public void deleteBookTest() {
        Book book = new Book(23, "Great", "Giri");
        bookService.deleteBook(book);
        verify(bookRepository, times(1)).delete(book);
    }

    @Test
    public void addBookTest() {
        Book book = new Book(100, "Wings", "APJK");
        when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertEquals(book, bookService.addBook(book));

    }


   /* @Test
    public void spyAddTest() {
        ArrayList<String> list = Mockito.spy(new ArrayList<String>());
        spyList.add("Ram");
        spyList.add("Rohan");
        spyList.add("admin");

        Assertions.assertEquals(3, list.size());

    }*/


  /*  @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        spyList.add("test");
        Assertions.assertEquals("test", spyList.get(0));
    }*/


    @Test
    public void testMockWithStub() {
        //try stubbing a method
        String expected = "Mock 100";
        when(mockList.get(100)).thenReturn(expected);

        Assertions.assertEquals(expected, mockList.get(100));
    }


    @Test
    public void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        String expected = "Spy 100";
        String name = "Tiger";
        //take note of using doReturn instead of when
        doReturn(expected).when(spyList).get(100);

        Assertions.assertEquals(expected, spyList.get(100));
    }


    @Spy
    List<String> spyList1 = new ArrayList<String>();

   /* @Test
    public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
        spyList1.add("one");
        spyList1.add("two");

        Mockito.verify(spyList1).add("one");
        Mockito.verify(spyList1).add("two");

        Assertions.assertEquals(2, spyList1.size());
    }*/

    @Spy
    List<String> spyOnList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

   /* @Test
    void test() {
        spyOnList.add("A");
        Assertions.assertEquals(1, spyOnList.size());
        Assertions.assertEquals("A", spyOnList.get(0));

        spyOnList.add("E");
        Assertions.assertEquals(2, spyOnList.size());
        Assertions.assertEquals("E", spyOnList.get(1));

        when(spyOnList.size()).thenReturn(10);
        Assertions.assertEquals(10, spyOnList.size());
    }*/

}

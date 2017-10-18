package cn.angusyu.test.ssm.controller;

import cn.angusyu.test.ssm.dto.AppointExecution;
import cn.angusyu.test.ssm.dto.Result;
import cn.angusyu.test.ssm.entity.Book;
import cn.angusyu.test.ssm.exception.OutOfStockException;
import cn.angusyu.test.ssm.exception.RepeatedAppointmentException;
import cn.angusyu.test.ssm.service.BookService;
import cn.angusyu.test.ssm.util.enums.AppointStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author AngusYu
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    private String list(Model model) {
        List<Book> books = bookService.listBooks();
        model.addAttribute("books", books);
        // list.jsp + model = ModelAndView
        // WEB-INF/pages/'list'.jsp
        return "list";
    }

    @RequestMapping("/{bookId}/detail")
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    /**
     * Appoint Using form submit.
     * @param bookId
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST,
            produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId,
                                             @RequestParam("studentId") Long studentId) {
        if (studentId == null || "".equals(studentId)) {
            return new Result<>(false, "Student ID cannot be null.");
        }
        return processAppoint(bookId,studentId);
    }

    @RequestMapping(value = "/{bookId}/appoint_by_ajax", method = RequestMethod.POST,
            produces = {"application/json; charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appointByJson(@PathVariable("bookId") Long bookId,
                                                   @RequestBody Map<String,Object> params) {
        String studentIdTemp=params.get("studentId").toString();
        if (studentIdTemp == null || "".equals(studentIdTemp)) {
            return new Result<>(false, "Student ID cannot be null.");
        }
        Long studentId=Long.parseLong(studentIdTemp);
        return processAppoint(bookId,studentId);
    }

    private Result<AppointExecution> processAppoint(Long bookId, Long studentId){
        AppointExecution appointExecution = null;
        try {
            appointExecution = bookService.appoint(bookId, studentId);
        } catch (OutOfStockException e1) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.OUT_OF_STOCK);
        } catch (RepeatedAppointmentException e2) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.REPEATED_APPOINTMENT);
        } catch (Exception e) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.SYSTEM_ERROR);
        }
        return new Result<AppointExecution>(true, appointExecution);
    }
}

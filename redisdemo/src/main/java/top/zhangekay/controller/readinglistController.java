package top.zhangekay.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zhangekay.dao.ReadingListRepo;
import top.zhangekay.entity.Book;

import java.util.List;

@RestController
@RequestMapping("/readingList")
public class readinglistController {

    @Autowired
    private ReadingListRepo readingListRepo;

    @RequestMapping(value = "/{reader}/",method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader , Model model){

        List<Book> readinglists = readingListRepo.findByreader(reader);
        if (readinglists != null){
            model.addAttribute("books",readinglists);

        }
        return "readingLists";
    }

    @RequestMapping(value = "/{reader}/",method = RequestMethod.POST)
    public String addreaderBooks(@PathVariable("reader") String reader , Book book){

        book.setReader(reader);
        readingListRepo.save(book);
        List<Book> readinglists = readingListRepo.findByreader(reader);
        return "redirect:/readingList/{reader}";
    }


}

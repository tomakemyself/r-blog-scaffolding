package com.blog.entity.book.dto;

import com.blog.entity.book.Book;
import com.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * ReadBookDto
 *
 * @author bobbi
 * @date 2019/01/28 16:44
 * @email 571002217@qq.com
 * @description
 */
@Data
public class BookDTO extends Book {

    List<Tag> tagList;
}

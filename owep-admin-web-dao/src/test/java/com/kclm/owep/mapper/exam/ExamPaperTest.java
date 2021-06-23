/****************************************
 * 2018 - 2021 版权所有 CopyRight(c) 快程乐码信息科技有限公司所有, 未经授权，不得复制、转发
 */

package com.kclm.owep.mapper.exam;

import com.kclm.owep.entity.vo.PaperVo;
import com.kclm.owep.mapper.ExamPaperMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/******************
 * @Author yejf
 * @Version v1.0
 * @Create 2021-06-23 17:26
 * @Description TODO
 */
@SpringBootTest
public class ExamPaperTest {
    @Autowired
    private ExamPaperMapper examPaperMapper;

    @Test
    public void testfindAllPaper() {
        final List<PaperVo> allPaper = examPaperMapper.findAllPaper("admin");
        allPaper.forEach(System.out::println);
    }

    @Test
    public void testfindPaperById() {
        final List<PaperVo> paperById = examPaperMapper.findPaperById(4, "admin");
        System.out.println(paperById);
    }
}

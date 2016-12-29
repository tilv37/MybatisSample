package net.xjdsz.service;

import net.xjdsz.entity.Info;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * Created by dingshuo on 2016/12/28.
 */
public class MybatisServeice {
    public void findALL(){
        String resource="SqlMapConfig.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            // 1.创建会话工场,传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);

            // 2.通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            // 3.通过sqlSession操作数据库
            // 第一个参数：映射文件中的statement的Id,等于namespace + "." + statement的id;
            // 第二个参数:指定和映射文件中所匹配的parameterType类型的参数;
            // sqlSession.selectOne结果是与映射文件所匹配的resultType类型的对象;
            // selectOne：查询一条结果
            Info user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args){
        MybatisServeice aaa=new MybatisServeice();
        aaa.findALL();
    }

}

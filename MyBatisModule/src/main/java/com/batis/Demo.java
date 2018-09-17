package com.batis;

import com.batis.bean.*;
import com.batis.mapper.CityResidentMapper;
import com.batis.mapper.IdentificationCardMapper;
import com.batis.mapper.PersonalHobbyMapper;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.tools.ant.types.Mapper;
import org.apache.tools.ant.util.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-08-21
 * Time: 13:38
 */
public class Demo {
    private  static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        String dataBaseId = sqlSessionFactory.getConfiguration().getDatabaseId();
        System.out.println("------------" + dataBaseId);
//    SqlSessionFactory sqlSessionFactory = JavaCodeInitSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
/*        CityResident CityResident = (CityResident) session.selectOne("com.batis.mapper.CityResidentMapper.selectCityResident", 1);
        System.out.println(CityResident.toString());*/
            List<CityResident> CityResidentList = session.selectList("com.batis.mapper.CityResidentMapper.selectCityResidents");
            System.out.println(CityResidentList.toString());
//        CityResident CityResident = (CityResident) session.selectOne("com.batis.mapper.CityResidentMapper.selectCityResident", 1);
//        System.out.println(CityResident);
            //定义映射器
            CityResidentMapper cityResidentMapper = session.getMapper(CityResidentMapper.class);
            IdentificationCardMapper identificationCardMapper = session.getMapper(IdentificationCardMapper.class);
            PersonalHobbyMapper personalHobbyMapper = session.getMapper(PersonalHobbyMapper.class);

            List<Map<String, Object>> mapList = cityResidentMapper.selectCityResidentList();
            System.out.println(mapList);
            IdentificationCard identificationCard = identificationCardMapper.searchIdentificationByIdCard(1L);
//            System.out.println(identificationCard);
            logger.info("content is {}",identificationCard.toString());
            //TODO -------2018-08-31 实现一对一级联的查询------------
            CityResidentIdentificationCard cityResidentIdentificationCard = cityResidentMapper.selectCityResidentById(1L);
            String identificationNumber = cityResidentIdentificationCard.getIdentificationCard().getIdentificationNumber();
            logger.debug("identificationNumber is {}",identificationNumber);
            System.out.println(cityResidentIdentificationCard.toString());

            List<PersonalHobby> personalHobbies = personalHobbyMapper.getPersonHobbyId(1L);
            System.out.println(personalHobbies.toString());
            //TODO -------2018-08-31 实现一对多的查询------------
            CityResidentIdentificationCardHobby cityResidentIdentificationCardHobby = cityResidentMapper.selectCityResidentsById(1L);
            System.out.println(cityResidentIdentificationCardHobby);
            //TODO 使用where元素添加数据
            CityResident cityResident = cityResidentMapper.findCityResidentsById(1L);
            if (cityResident!=null){
                System.out.println(cityResident.toString());
            }
            //TODO 使用trim元素查询数据
            CityResident cityResident1 = cityResidentMapper.findCityResidentsUseTrim(1L,"zhang");
            if (cityResident1!=null){
                System.out.println(cityResident1.toString());
            }
            //TODO 使用set元素
            CityResident cityResidentRequest = new CityResident();
            cityResidentRequest.setId(1L);
            cityResidentRequest.setUserName("张三");
            cityResidentRequest.setUserAge(22);
            Integer updateCount = cityResidentMapper.updateCityResidentById(cityResidentRequest);
            if (updateCount>0){
                CityResident cityResidentResponse = cityResidentMapper.findCityResidentsById(1L);
                if (cityResidentResponse!=null){
                    System.out.println(cityResidentResponse.toString());
                }
            }
//            session.commit();
            CityResident cityResidentRequest2 = new CityResident();
            cityResidentRequest2.setId(1L);
            cityResidentRequest2.setUserName("zhangsan");
            cityResidentRequest2.setUserAge(23);
            Integer updateCounts = cityResidentMapper.updateCityResidentUseTrimSetById(cityResidentRequest2);
            if (updateCounts>0){
                CityResident cityResidentResponse = cityResidentMapper.findCityResidentsById(1L);
                if (cityResidentResponse!=null){
                    System.out.println(cityResidentResponse.toString());
                }
            }
            System.out.println("--------------------------------------------------------------------");
            List<Long> ids = new ArrayList<>();
            ids.add(1L);
            ids.add(2L);
            List<CityResident> cityResidents = cityResidentMapper.selectCityResidentUseForeachById(ids);
            if (!org.apache.commons.collections4.CollectionUtils.isEmpty(cityResidents)){
                System.out.println("*********"+cityResidents.toString());
            }
            //TODO 使用bind元素
            List<CityResident> cityResidentList = cityResidentMapper.selectCityResidentUseBindByUserName("zhang");
            if (!org.apache.commons.collections4.CollectionUtils.isEmpty(cityResidentList)){
                System.out.println("-------"+cityResidentList.toString());
            }
//            MapperProxy;
//            MapperProxyFactory
//            XMLConfigBuilder
//            MappedStatement
        } finally {
            session.commit();
            session.close();
        }


    }

    public static SqlSessionFactory JavaCodeInitSessionFactory() {
        PooledDataSource dataSource = getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(CityResidentMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    private static PooledDataSource getDataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("root@123");
        return dataSource;
    }

    @Test
    public void test1() {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);

        Optional.of(result2).ifPresent(System.out::println);

        List<CityResident> CityResidentList = new ArrayList<>();
        CityResidentList.add(new CityResident(1L, "zhangsan", 20, 1));
        CityResidentList.add(new CityResident(2L, "lisi", 21, 2));
        CityResidentList.add(new CityResident(3L, "wangwu", 22, 1));
        CityResidentList.add(new CityResident(4L, "zhaoliu", 23, 2));
        //TODO 20+42+66+92=128+92=220
        double sum = CityResidentList.parallelStream().mapToDouble(e -> e.getId() * e.getUserAge()).sum();
        System.out.println(sum);

        Collections.sort(CityResidentList, new Comparator<CityResident>() {
            @Override
            public int compare(CityResident o1, CityResident o2) {
                if (o1.getUserAge() < o2.getUserAge()) {
                    return 1;
                }
                if (o1.getUserAge().intValue() == o2.getUserAge().intValue()) {
                    return 0;
                }

                return -1;
            }
        });
        System.out.println(CityResidentList);

        System.out.println("2017-12-04 15:44:51".compareTo("2017-12-04 15:44:52"));

//    TypeAliasRegistry
    }

    /**
     *
     */
    @Test
    public void testMethod(){

        List<CityResident> cityResidentList = new ArrayList<>();
        cityResidentList.add(new CityResident(1L, "zhangsan", 20, 1));
        cityResidentList.add(new CityResident(1L, "zhangsan", 20, 1));
        cityResidentList.add(new CityResident(1L, "zhangsan", 20, 1));
        cityResidentList.add(new CityResident(1L, "zhangsan", 20, 1));
        Map<CityResident,List<CityResident>> map  = new HashMap<>();
        Set<CityResident> set = new HashSet<>(cityResidentList);
        Iterator<CityResident> iterator = set.iterator();
        while (iterator.hasNext()) {
            CityResident cityResident = iterator.next();
            if (!map.containsKey(cityResident)){
                List<CityResident> list = new ArrayList<>();
                list.add(cityResident);
                map.put(cityResident,cityResidentList);
            }else{
                List<CityResident> cityResidents = map.get(cityResident);
                cityResidents.add(cityResident);
            }
            System.out.println(cityResident);
            System.out.println(cityResidentList.contains(cityResident));
            System.out.println(map.size());
            List<CityResident> list = map.get(cityResident);
            System.out.println(list.size());
            System.out.println(list);

        }
    }
}

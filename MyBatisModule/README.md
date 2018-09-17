# 使用where元素
    减少没必要的条件的时候sql还是可以正常的执行，后面的条件成立的时候还是可以正常的执行
    
        <!--使用where trim set元素-->
        <select id="findCityResidentsById" resultMap="BaseResultMap">
            SELECT <include refid="BaseColumns"/>
            FROM <include refid="BaseTable"/>
            <where>
                <if test="id!=null">
                    AND id=#{id}
                </if>
            </where>
        </select>
#使用trim元素

     　 prefix：前缀　　　　　　
    　　prefixoverride：去掉第一个and或者是or
    
        <select id="findCityResidentsUseTrim" resultMap="BaseResultMap">
        SELECT <include refid="BaseColumns"/>
        FROM <include refid="BaseTable"/>
        <trim prefix="where" prefixOverrides="and">
            <if test="id!=null">
              AND id=#{id}
            </if>
            <if test="userName!=null and userName!=''">
              AND name LIKE concat('%',#{userName},'%')
            </if>
        </trim>
        </select>
      
# 使用set元素

    MyBatis在生成update语句时若使用if标签，如果前面的if没有执行，则可能导致有多余逗号的错误。
    使用set标签可以将动态的配置SET 关键字，和剔除追加到条件末尾的任何不相关的逗号。
    没有使用if标签时，如果有一个参数为null，都会导致错误
        <!--使用set元素-->
        <update id="updateCityResidentById">
            UPDATE <include refid="BaseTable"/>
            <set>
              <if test="cityResident.userName!=null and cityResident.userName!=''">
                name = #{cityResident.userName},
              </if>
              <if test="cityResident.userAge!=null">
                age = #{cityResident.userAge}
              </if>
            </set>
            WHERE id = #{cityResident.id}
        </update>
    
        <!--使用trim set元素-->
        <update id="updateCityResidentUseTrimSetById">
            UPDATE <include refid="BaseTable"/>
            <trim prefix="SET" suffixOverrides=",">
                <if test="cityResident.userName!=null and cityResident.userName!=''">
                    name = #{cityResident.userName},
                </if>
                <if test="cityResident.userAge!=null">
                    age = #{cityResident.userAge},
                </if>
            </trim>
            WHERE id = #{cityResident.id}
        </update>



#使用foreach元素
    作用：遍历集合，支持数组和List,Set接口的集合，对此提供遍历的功能
    <select id="selectCityResidentUseForeachById" resultMap="BaseResultMap">
      SELECT <include refid="BaseColumns"/>
      FROM <include refid="BaseTable"/>
      WHERE id IN
        <foreach collection="ids" item="id" index="index" open="(" separator="," close=")">
           #{id}
        </foreach>
    </select>
    
#使用bind元素
    bind元素的作用是通过OGNL表达式去自定义一个上下文变量，这样方便我们使用。但是由于不同的数据库使用的便是都有可能不太一样，
    mysql的模糊查询使用的是% oracle使用的是||，这样需要使用两种形式去实现。但是使用bind之后我们值需要使用mybatis的语言即可
    
#-------------------------------------------------------------------------------------------------------------------------------    
#MyBatis的解析与运行原理    
        SqlSessionFactory核心类之一，其功能是创建核心的接口SqlSession,需要创建SqlSessionFactory,为此我们需要提供配置文件和相
        关的参数.构建大致分为两部:
        1.通过org.apache.ibatis.builder.xml.XMLConfigBuilder解析XML文件独处配置参数,并将读出的数据存入org.apache.ibatis.session.Configuration
        类中，MyBatis几乎所有的配置都是存在这里.
        
        2.使用Configuration对象去创建SqlSessionFactory。实际上SqlSessionFactory是一个接口,但是MyBatis提供了实现类org.apache.ibatis.session.defaults.DefaultSqlSessionFactory
        ,一般灰使用它去创建，没有必须要自己去实现SqlsessionFactory
        
        
#构建Configuration

    SqlSessionFactory的构建中，Configuration是最重要的，它的作用如下:
    . 读入配置文件，包括基础配置的XML文件和映射器的XML文件.
    .初始化基础配置，比如MyBatis的别名等，一些重要的类对象，例如，插件，映射器，ObjectFactory和typeHandler对象.
    .提供单利，为后续创建SessionFactory服务并提供配置的参数.
    .执行一些重要的对象方法，初始化配置信息
    
    MyBatis会读取XML配置信息。然后将这些信息保存在Configuration类的单例中。
      this.propertiesElement(root.evalNode("properties"));
      this.typeAliasesElement(root.evalNode("typeAliases"));
      this.pluginElement(root.evalNode("plugins"));
      this.objectFactoryElement(root.evalNode("objectFactory"));
      this.objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
      this.settingsElement(root.evalNode("settings"));
      this.environmentsElement(root.evalNode("environments"));
      this.databaseIdProviderElement(root.evalNode("databaseIdProvider"));
      this.typeHandlerElement(root.evalNode("typeHandlers"));
      this.mapperElement(root.evalNode("mappers"));
           
           
      


#映射器的内部组成
    由于插件需要频繁的访问映射器的内部组成，我们需要单独的研究映射器的组成，映射器一般由下面三个部分组成:
    .MappedStatement,它保存映射器的一个节点(select|insert|delete|update).包括许多我们配置的SQL,SQL的id，缓存信息,resultMap，parameterType,resultType,languageDriver等重要配置内容.
    .SqlSource，它是提供BoundSql对象的地方,它是MappedStatement的一个属性。
    .BoundSql,它是建立SQL和参数的地方.它由3个常用的属性：SQL,parameterObject,parameterMappings
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
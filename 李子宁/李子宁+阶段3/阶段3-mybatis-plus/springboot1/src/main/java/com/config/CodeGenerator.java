package com.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "123456";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String AUTHOR = "李小宁";
    //���ɵ��ļ�������ĸ�Ŀ¼
    public static final String OUTPUT_FILE = "D:\\eclipse-jee-2019-06-R-win32-x86_64\\eclipse-workspace\\springboot1\\src\\main\\java";
    //�������ᰴ��com/example/demo������ʽ������
    public static final String PACKAGE = "com.demo";
    //TODO ����������ο�http://mp.baomidou.com/#/generate-code
 
    public void generateByTables(boolean serviceNameStartWithI, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(DB_URL)
                .setUsername(USER_NAME)
                .setPassword(PASSWORD)
                .setDriverName(DRIVER);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//�޸��滻������Ҫ�ı������������������
        config.setActiveRecord(false)
                .setAuthor(AUTHOR)
                .setOutputDir(OUTPUT_FILE)
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(PACKAGE)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }
}

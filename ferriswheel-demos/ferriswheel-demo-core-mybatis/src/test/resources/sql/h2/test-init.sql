INSERT INTO T_AUTHOR (ID, USER_ID, USER_NAME, EMAIL, DESCRIBE_INFO ) VALUES (1, 'michael', 'michael', 'michael@micmiu.com', null);
INSERT INTO T_AUTHOR (ID, USER_ID, USER_NAME, EMAIL, DESCRIBE_INFO ) VALUES (2, 'sun', 'sun', 'sun@micmiu.com', null);
INSERT INTO T_AUTHOR (ID, USER_ID, USER_NAME, EMAIL, DESCRIBE_INFO ) VALUES (3, 'hazel', 'hazel', 'hazel@micmiu.com', null);

insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (1,1,'mvc-ssm','j2ee','http://micmiu.com/j2ee/mvc','2014-06-11');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (2,1,'sso','SSO','http://www.micmiu.com/category/enterprise-app/sso/','2014-08-01');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (3,1,'webservice','SOA','http://www.micmiu.com/category/soa/webservice/','2014-08-02');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (4,1,'hadoop','bigdata','http://www.micmiu.com/category/bigdata/hadoop/','2014-08-03');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (5,1,'hive','bigdata','http://www.micmiu.com/category/bigdata/hive/','2014-08-04');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (6,1,'hbase','bigdata','http://www.micmiu.com/category/bigdata/hbase/','2014-08-05');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (7,2,'spark','bigdata','http://www.micmiu.com/category/bigdata/spark/','2014-08-06');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (8,2,'sqoop','bigdata','http://www.micmiu.com/category/bigdata/sqoop/','2014-08-07');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (9,3,'hibernate','j2ee','http://www.micmiu.com/category/j2ee/hibernate/','2014-08-08');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (10,3,'spring','j2ee','http://www.micmiu.com/category/j2ee/spring/','2014-08-09');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (11,3,'jta','j2ee','http://www.micmiu.com/category/j2ee/jta/','2014-08-10');
insert into T_ARTICLE (ID, AUTHOR_ID, TITLE, CATEGORY, URL, PUBLISH_DATE) values (12,3,'java','language','http://www.micmiu.com/category/lang/java/','2014-08-11');

-- t_blog
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('1', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'spring', 'http://www.micmiu.com/category/j2ee/');
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('2', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'struts', 'http://www.micmiu.com/category/soa/');
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('3', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'hibernate', 'http://www.micmiu.com/category/opensource/');
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('4', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'shiro', 'http://www.micmiu.com/category/nosql/');
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('5', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'sso', 'http://www.micmiu.com/category/architecture/');
INSERT INTO T_BLOG (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('6', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'cas', 'http://www.micmiu.com/category/lang/');


INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('1', 'index', 'menu.index', '', 'index.do', '1', null);
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('2', 'system', 'menu.system', '', '', '1000', null);
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('3', 'user', 'menu.system.user', '', 'system/user.do?method=showList', '1100', '2');
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('4', 'role', 'menu.system.role', '', 'system/role.do?method=showList', '1200', '2');
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('5', 'demo', 'menu.demo', '', '', '2000', null);
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('6', 'demo_common', 'menu.demo.common', '', 'demo/easyui/index.do', '2100', '5');
INSERT INTO T_MENU (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('7', 'demo_crud', 'menu.demo.crud', '', 'demo/easyui/crud.do?method=showList', '2200', '5');

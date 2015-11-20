
-- t_sys_user
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('1', 'admin@micmiu.com', 'admin', 'Admin', null, 'admin');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('2', 'user@micmiu.com', 'user', 'User', null, 'user');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('3', 'sjsky007@gmail.com', 'michael', 'Michael', null, 'michael');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('4', 'user1@micmiu.com', 'user1', 'User1', null, 'user1');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('5', 'user5@micmiu.com', 'user5', 'User5', null, 'user5');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('6', 'user6@micmiu.com', 'user6', 'User6', null, 'user6');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('7', 'user7@micmiu.com', 'user7', 'User7', null, 'user7');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('8', 'user8@micmiu.com', 'user8', 'User8', null, 'user8');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('9', 'user9@micmiu.com', 'user9', 'User9', null, 'user9');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('10', 'user10@micmiu.com', 'user10', 'User10', null, 'user10');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('11', 'user11@micmiu.com', 'user11', 'User11', null, 'user11');
INSERT INTO t_sys_user (ID, EMAIL, LOGIN_NAME, NAME, OTHER, PASSWORD) VALUES ('12', 'user12@micmiu.com', 'user12', 'User12', null, 'user12');

-- t_sys_role
INSERT INTO t_sys_role (ID, ROLE_NAME) VALUES ('1', '超级管理员');
INSERT INTO t_sys_role (ID, ROLE_NAME) VALUES ('2', '管理员');
INSERT INTO t_sys_role (ID, ROLE_NAME) VALUES ('3', '普通用户');
INSERT INTO t_sys_role (ID, ROLE_NAME) VALUES ('4', 'demos');

-- t_sys_u2r
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('1', '1');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('3', '2');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('2', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('4', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('5', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('6', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('7', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('8', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('9', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('10', '3');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('11', '4');
INSERT INTO t_sys_u2r (USER_ID, ROLE_ID) VALUES ('12', '4');

-- t_sys_menu
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('1', 'index', 'menu.index', '', 'index.do', '1', null);
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('2', 'system', 'menu.system', '', '', '1000', null);
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('3', 'user', 'menu.system.user', '', 'system/user.do?method=showList', '1100', '2');
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('4', 'role', 'menu.system.role', '', 'system/role.do?method=showList', '1200', '2');
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('5', 'demo', 'menu.demo', '', '', '2000', null);
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('6', 'demo_common', 'menu.demo.common', '', 'demo/easyui/index.do', '2100', '5');
INSERT INTO t_sys_menu (ID, ALIAS_NAME, MENU_NAME, MENU_TYPE, MENU_URL, ORDER_NUM, PARENT_ID) VALUES ('7', 'demo_crud', 'menu.demo.crud', '', 'demo/easyui/crud.do?method=showList', '2200', '5');

--t_sys_permssion
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('1', 'read', 'module.anno.index', 'anno', '1');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('101', 'read', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('102', 'update', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('103', 'create', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('104', 'delete', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('105', 'export', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('106', 'print', 'module.system.user', 'user', '3');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('107', 'read', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('108', 'update', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('109', 'create', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('110', 'delete', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('111', 'export', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('112', 'print', 'module.system.role', 'role', '4');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('121', 'read', 'module.demo.common', 'demo_common', '6');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('122', 'update', 'module.demo.common', 'demo_common', '6');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('123', 'create', 'module.demo.common', 'demo_common', '6');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('124', 'delete', 'module.demo.common', 'demo_common', '6');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('125', 'read', 'module.demo.crud', 'demo_common', '7');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('126', 'update', 'module.demo.crud', 'demo_common', '7');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('127', 'create', 'module.demo.crud', 'demo_common', '7');
INSERT INTO t_sys_permssion (ID, OPERATION, RES_CN_NAME, RES_NAME, MENU_ID) VALUES ('128', 'delete', 'module.demo.crud', 'demo_common', '7');

-- t_sys_r2p
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '1');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '101');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '102');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '103');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '104');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '105');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '106');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '107');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '108');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '109');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '110');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '111');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '112');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '121');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '122');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '123');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '124');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '125');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '126');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '127');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('1', '128');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '1');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '101');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '102');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '103');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '104');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '105');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '106');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '107');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '108');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '109');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '110');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '111');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '112');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '121');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '122');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '123');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '124');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '125');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '126');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '127');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('2', '128');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('3', '1');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('3', '101');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('3', '107');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('3', '121');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('3', '125');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('4', '1');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('4', '121');
INSERT INTO t_sys_r2p (ROLE_ID, PERM_ID) VALUES ('4', '125');

-- t_blog
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('1', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'spring', 'http://www.micmiu.com/category/j2ee/');
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('2', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'struts', 'http://www.micmiu.com/category/soa/');
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('3', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'hibernate', 'http://www.micmiu.com/category/opensource/');
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('4', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'shiro', 'http://www.micmiu.com/category/nosql/');
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('5', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'sso', 'http://www.micmiu.com/category/architecture/');
INSERT INTO t_blog (ID, AUTHOR, CATEGORY, CREATER, OTHER, PUBLISH_DATE, TITLE, URL) VALUES ('6', 'michael', 'j2ee', 'michael', '', '2013-04-07', 'cas', 'http://www.micmiu.com/category/lang/');


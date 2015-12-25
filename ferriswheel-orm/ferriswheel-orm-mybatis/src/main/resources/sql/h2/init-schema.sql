drop table  if exists T_BLOG;

create table T_BLOG (
  ID bigint identity PRIMARY KEY,
  TITLE varchar(50) not null,
  AUTHOR varchar(20),
  CATEGORY varchar(50),
  URL varchar(256),
  PUBLISH_DATE date
);


create table T_USER (
  ID bigint identity PRIMARY KEY,
  USER_ID varchar(20) not null,
  USER_NAME varchar(20),
  PASSWORD varchar(32),
  ROLE varchar(20),
  CREATE_DATE date
)
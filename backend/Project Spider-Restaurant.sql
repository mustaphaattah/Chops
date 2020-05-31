TABLE CHEF(
  firstname VARCHAR,
  lastname VARCHAR,
  dateCreated VARCHAR,
  lastUpdated VARCHAR,
  loginType ENUM CHECKS ('Google', 'Local', 'Facebook'),
  password VARCHAR,
  profileId VARCHAR UNIQUE,
  username VARCHAR UNIQUE,
  email VARCHAR UNIQUE,
  id INT AUTO INCREMENT
)


TABLE CUSTOMER (
  firstname VARCHAR,
  lastname VARCHAR,
  dateCreated VARCHAR,
  lastUpdated VARCHAR,
  loginType ENUM CHECKS ('Google', 'Local', 'Facebook'),
  password VARCHAR,
  profileId VARCHAR UNIQUE,
  username VARCHAR UNIQUE,
  email VARCHAR UNIQUE,
  id INT AUTO INCREMENT,
)

TABLE ADDRESS (
  postalCode CHAR(6),
  city VARCHAR,
  province VARCHAR,
  line1 VARCHAR,
  line2 VARCHAR,
  customerId FOREIGN KEY,
  id INT AUTO INCREMENT
)

TABLE MENU_CATEGORY (
  name VARCHAR,
  id INT AUTO INCREMENT,
  chefId FOREIGN KEY
)

TABLE MENU_ITEM (
  name VARCHAR,
  description VARCHAR,
  price VARCHAR,
  image VARCHAR,
)

TABLE ORDER(
    chefId FOREIGN KEY,
    customerId FOREIGN KEY,
    dateCreated VARCHAR,
    dateCompleted VARCHAR,
    status ENUM(pending, confirmed, canceled),
    completed BOOLEAN,
    orderItems FOREIGN KEY,
    total,
    speacial instructions
)

TABLE ORDER_ITEM (
    name FOREIGN KEY ,
    price,
    quantity,
    special instructions
)

CREATE TABLE category(
    id VARCHAR(50) PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);

CREATE TABLE skill(
    id VARCHAR(50) PRIMARY KEY,
    skill_name VARCHAR(50) NOT NULL,
    category_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);
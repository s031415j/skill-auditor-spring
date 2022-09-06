CREATE TABLE category(
    id VARCHAR PRIMARY KEY,
    category_name VARCHAR NOT NULL
);

CREATE TABLE skill(
    id VARCHAR PRIMARY KEY,
    skill_name VARCHAR NOT NULL,
    category_id VARCHAR NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);
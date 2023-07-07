CREATE TABLE voting_topics
(
    id       bigserial PRIMARY KEY,
    subject  varchar      not null,
    start_date timestamp(0) not null,
    end_date timestamp(0) not null
);

CREATE TABLE users
(
    id       bigserial PRIMARY KEY,
    name  varchar      not null
);

CREATE TABLE associate_votes
(
    id       bigserial PRIMARY KEY,
    user_id bigint NOT NULL REFERENCES users(id),
    voting_topic_id bigint NOT NULL REFERENCES voting_topics(id),
    vote bool not null
);
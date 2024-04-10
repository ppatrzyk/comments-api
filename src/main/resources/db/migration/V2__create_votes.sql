create table if not exists votes (
    id uuid default gen_random_uuid(),
    ts timestamp with time zone default now() not null,
    score int not null,
    comment_id uuid not null references comments(id) on delete cascade,
    primary key (id),
    constraint valid_score check (score in (-1, 1))
)
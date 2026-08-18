CREATE TABLE activity_logs (
   id BIGSERIAL PRIMARY KEY,
   user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
   activity_id BIGINT NOT NULL REFERENCES activities(id) ON DELETE CASCADE,
   location_id BIGINT REFERENCES locations(id) ON DELETE SET NULL,

   action_taken VARCHAR(50) NOT NULL,       -- 'CHECK_IN', 'CHECK_OUT', 'COMPLETED', 'SKIPPED', 'WARNING_MISSED'
   event_timestamp TIMESTAMP NOT NULL,      -- Thời gian thực tế diễn ra
   note TEXT,                               -- Vd: "Rời cty muộn do tắc đường", "Mua được sữa giảm giá"

   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
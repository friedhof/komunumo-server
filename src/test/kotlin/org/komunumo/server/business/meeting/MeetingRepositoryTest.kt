/*
 * Komunumo – Open Source Community Manager
 * Copyright (C) 2018 Java User Group Switzerland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.komunumo.server.business.meeting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.Duration
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@DataMongoTest
class MeetingRepositoryTest(@Autowired private val repository: MeetingRepository) {

    @Test
    fun `A meeting can be saved`() {
        val newMeeting = Meeting(
                id = null,
                title = "Komunumo Test Event",
                subtitle = "This is a test",
                description = "Let's do something very useful!",
                dateTime = LocalDateTime.of(2018, 8, 30, 18, 0),
                duration = Duration.ofMinutes(90)
        )
        val savedMeeting = repository.save(newMeeting)
        assertThat(savedMeeting.id).isNotBlank()
        assertThat(savedMeeting).isEqualTo(newMeeting.copy(id = savedMeeting.id))
    }

}
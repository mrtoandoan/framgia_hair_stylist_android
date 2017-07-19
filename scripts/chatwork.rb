	require "chatwork"

	# Create message
	ChatWork.api_key = "8f247d4a711fb2326012a8ad47243db3"
	ChatWork::Message.create(room_id: 79465686, body: "[info][To:2309461] [To:2357769]  CI Build Success :x!  \n #{ARGV[0]} [/info]")
package com.wego.web.community;


	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	@Data
	@Component
	@AllArgsConstructor
	@NoArgsConstructor
	@Lazy
	public class Community  {

		private String artseq, img, uid, comments, msg, rating, boardType, title, content;

}

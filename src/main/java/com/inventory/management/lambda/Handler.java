package com.inventory.management.lambda;

import java.sql.Connection;
import java.sql.DriverManager;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Object, String> {

	@Override
	public String handleRequest(Object input, Context context) {
		LambdaLogger logger = context.getLogger();

		try {
			// PostgreSQL JDBCドライバーを明示的にリロード
			Class.forName("org.postgresql.Driver");

			String jdbcUrl = System.getenv("DB_URL");
			String dbUser = System.getenv("DB_USER");
			String dbPassword = System.getenv("DB_PASSWORD");

			try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
				if (conn != null && !conn.isClosed()) {
					logger.log("RDS接続成功");
					return ":white_check_mark: RDS接続成功！";
				} else {
					logger.log("接続オブジェクトは取得できたが無効");
					return "warnin: 接続オブジェクトは取得できたが無効です。";
				}
			} catch (Exception e) {
				logger.log("接続失敗: " + e.getMessage());
				return ":x: 接続失敗: " + e.getMessage();
			}
		} catch (ClassNotFoundException e) {
			logger.log(":x: JDBCドライバが見つかりません: " + e.getMessage());
			return ":x: JDBCドライバが見つかりません: " + e.getMessage();
		}
	}
}

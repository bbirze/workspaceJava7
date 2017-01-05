package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetMetaData;
import javax.sql.rowset.BaseRowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.Joinable;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetWarning;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.spi.SyncProvider;
import javax.sql.rowset.spi.SyncProviderException;

public class MyRowSetFactory implements RowSetFactory {
	
	protected RowSetFactory rsFact;
	
	public MyRowSetFactory() throws SQLException  {		// Constructor
		rsFact = RowSetProvider.newFactory("com.sun.rowset.RowSetFactoryImpl", null);
	}

	public CachedRowSet createCachedRowSet() throws SQLException {
		return rsFact.createCachedRowSet(); 			// return default impl
	}

	public FilteredRowSet createFilteredRowSet() throws SQLException {
		return rsFact.createFilteredRowSet(); 			// return default impl
	}

	public JdbcRowSet createJdbcRowSet() throws SQLException {
		return rsFact.createJdbcRowSet(); 				// return default impl
	}

	public WebRowSet createWebRowSet() throws SQLException {
		return rsFact.createWebRowSet(); 				// return default impl
	}

	public JoinRowSet createJoinRowSet() throws SQLException {
		return new myJoinRowSet(); 						// return MY Implementation!
	}
	
														// My JoinRowSet Implementation
	class myJoinRowSet extends BaseRowSet implements JoinRowSet {

		@Override
		public void readXml(Reader reader) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void readXml(InputStream iStream) throws SQLException,
				IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void writeXml(Writer writer) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void writeXml(OutputStream oStream) throws SQLException,
				IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void writeXml(ResultSet rs, Writer writer) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void writeXml(ResultSet rs, OutputStream oStream)
				throws SQLException, IOException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void acceptChanges() throws SyncProviderException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void acceptChanges(Connection con) throws SyncProviderException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean columnUpdated(int idx) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean columnUpdated(String columnName) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void commit() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public CachedRowSet createCopy() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CachedRowSet createCopyNoConstraints() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CachedRowSet createCopySchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public RowSet createShared() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void execute(Connection conn) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int[] getKeyColumns() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResultSet getOriginal() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResultSet getOriginalRow() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getPageSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public RowSetWarning getRowSetWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SyncProvider getSyncProvider() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getTableName() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean nextPage() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void populate(ResultSet data) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void populate(ResultSet rs, int startRow) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean previousPage() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void release() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void restoreOriginal() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void rollback() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void rollback(Savepoint s) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void rowSetPopulated(RowSetEvent event, int numRows)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setKeyColumns(int[] keys) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMetaData(RowSetMetaData md) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setOriginalRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setPageSize(int size) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setSyncProvider(String provider) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setTableName(String tabName) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Collection<?> toCollection() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<?> toCollection(int column) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<?> toCollection(String column) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void undoDelete() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void undoInsert() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void undoUpdate() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void execute() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean absolute(int row) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void afterLast() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeFirst() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void cancelRowUpdates() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void clearWarnings() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void close() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int findColumn(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean first() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Array getArray(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Array getArray(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getAsciiStream(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getAsciiStream(String columnLabel)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBigDecimal(int columnIndex, int scale)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBigDecimal(String columnLabel, int scale)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getBinaryStream(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getBinaryStream(String columnLabel)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Blob getBlob(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Blob getBlob(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean getBoolean(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean getBoolean(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public byte getByte(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public byte getByte(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public byte[] getBytes(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public byte[] getBytes(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Reader getCharacterStream(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Reader getCharacterStream(String columnLabel)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Clob getClob(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Clob getClob(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getCursorName() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Date getDate(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Date getDate(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Date getDate(int columnIndex, Calendar cal) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Date getDate(String columnLabel, Calendar cal)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public double getDouble(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getDouble(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getFloat(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getFloat(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getHoldability() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getInt(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getInt(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getLong(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getLong(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ResultSetMetaData getMetaData() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Reader getNCharacterStream(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Reader getNCharacterStream(String columnLabel)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NClob getNClob(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NClob getNClob(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getNString(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getNString(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getObject(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getObject(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getObject(int columnIndex, Map<String, Class<?>> map)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getObject(String columnLabel, Map<String, Class<?>> map)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T getObject(int columnIndex, Class<T> type)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T getObject(String columnLabel, Class<T> type)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Ref getRef(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Ref getRef(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getRow() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public RowId getRowId(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public RowId getRowId(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SQLXML getSQLXML(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SQLXML getSQLXML(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public short getShort(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public short getShort(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Statement getStatement() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getString(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getString(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Time getTime(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Time getTime(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Time getTime(int columnIndex, Calendar cal) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Time getTime(String columnLabel, Calendar cal)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Timestamp getTimestamp(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Timestamp getTimestamp(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Timestamp getTimestamp(int columnIndex, Calendar cal)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Timestamp getTimestamp(String columnLabel, Calendar cal)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public java.net.URL getURL(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public java.net.URL getURL(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getUnicodeStream(int columnIndex)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public InputStream getUnicodeStream(String columnLabel)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SQLWarning getWarnings() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void insertRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isAfterLast() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isBeforeFirst() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isClosed() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isFirst() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isLast() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean last() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void moveToCurrentRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void moveToInsertRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean next() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean previous() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void refreshRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean relative(int rows) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean rowDeleted() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean rowInserted() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean rowUpdated() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void updateArray(int columnIndex, Array x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateArray(String columnLabel, Array x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(int columnIndex, InputStream x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(String columnLabel, InputStream x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(int columnIndex, InputStream x, int length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(String columnLabel, InputStream x,
				int length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(int columnIndex, InputStream x,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateAsciiStream(String columnLabel, InputStream x,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBigDecimal(int columnIndex, BigDecimal x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBigDecimal(String columnLabel, BigDecimal x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(int columnIndex, InputStream x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(String columnLabel, InputStream x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(int columnIndex, InputStream x,
				int length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(String columnLabel, InputStream x,
				int length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(int columnIndex, InputStream x,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBinaryStream(String columnLabel, InputStream x,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(int columnIndex, Blob x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(String columnLabel, Blob x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(int columnIndex, InputStream inputStream)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(String columnLabel, InputStream inputStream)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(int columnIndex, InputStream inputStream,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBlob(String columnLabel, InputStream inputStream,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBoolean(int columnIndex, boolean x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBoolean(String columnLabel, boolean x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateByte(int columnIndex, byte x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateByte(String columnLabel, byte x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBytes(int columnIndex, byte[] x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateBytes(String columnLabel, byte[] x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(int columnIndex, Reader x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(String columnLabel, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(int columnIndex, Reader x, int length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(String columnLabel, Reader reader,
				int length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(int columnIndex, Reader x, long length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateCharacterStream(String columnLabel, Reader reader,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(int columnIndex, Clob x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(String columnLabel, Clob x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(int columnIndex, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(String columnLabel, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(int columnIndex, Reader reader, long length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateClob(String columnLabel, Reader reader, long length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateDate(int columnIndex, Date x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateDate(String columnLabel, Date x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateDouble(int columnIndex, double x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateDouble(String columnLabel, double x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateFloat(int columnIndex, float x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateFloat(String columnLabel, float x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateInt(int columnIndex, int x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateInt(String columnLabel, int x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateLong(int columnIndex, long x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateLong(String columnLabel, long x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNCharacterStream(int columnIndex, Reader x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNCharacterStream(String columnLabel, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNCharacterStream(int columnIndex, Reader x,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNCharacterStream(String columnLabel, Reader reader,
				long length) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(int columnIndex, NClob nClob)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(String columnLabel, NClob nClob)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(int columnIndex, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(String columnLabel, Reader reader)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(int columnIndex, Reader reader, long length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNClob(String columnLabel, Reader reader, long length)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNString(int columnIndex, String nString)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNString(String columnLabel, String nString)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNull(int columnIndex) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateNull(String columnLabel) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateObject(int columnIndex, Object x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateObject(String columnLabel, Object x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateObject(int columnIndex, Object x, int scaleOrLength)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateObject(String columnLabel, Object x, int scaleOrLength)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateRef(int columnIndex, Ref x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateRef(String columnLabel, Ref x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateRow() throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateRowId(int columnIndex, RowId x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateRowId(String columnLabel, RowId x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateSQLXML(int columnIndex, SQLXML xmlObject)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateSQLXML(String columnLabel, SQLXML xmlObject)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateShort(int columnIndex, short x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateShort(String columnLabel, short x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateString(int columnIndex, String x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateString(String columnLabel, String x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTime(int columnIndex, Time x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTime(String columnLabel, Time x) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTimestamp(int columnIndex, Timestamp x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTimestamp(String columnLabel, Timestamp x)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean wasNull() throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <T> T unwrap(Class<T> iface) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int[] getMatchColumnIndexes() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String[] getMatchColumnNames() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setMatchColumn(int columnIdx) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMatchColumn(int[] columnIdxes) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMatchColumn(String columnName) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setMatchColumn(String[] columnNames) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsetMatchColumn(int columnIdx) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsetMatchColumn(int[] columnIdxes) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsetMatchColumn(String columnName) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void unsetMatchColumn(String[] columnName) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRowSet(Joinable rowset) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRowSet(RowSet rowset, int columnIdx) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRowSet(RowSet rowset, String columnName)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRowSet(RowSet[] rowset, int[] columnIdx)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addRowSet(RowSet[] rowset, String[] columnName)
				throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getJoinType() throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String[] getRowSetNames() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<?> getRowSets() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getWhereClause() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setJoinType(int joinType) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean supportsCrossJoin() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean supportsFullJoin() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean supportsInnerJoin() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean supportsLeftOuterJoin() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean supportsRightOuterJoin() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public CachedRowSet toCachedRowSet() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	

}

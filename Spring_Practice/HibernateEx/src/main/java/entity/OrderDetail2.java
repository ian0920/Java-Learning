package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.OrderDetail2.CompositeDetail;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

// 複合主鍵的永續類別 annotation 設定可參考以下程式碼與註解說明，有 @IdClass 與 @EmbeddedId 兩種設定方式都可以

@Entity
@Table(name = "orderdetail2")
@IdClass(CompositeDetail.class)
public class OrderDetail2 {
	// 搭配 @IdClass 標註，oid 需要有 @Id
	@Id 
	@Column(name = "oid")
	private Integer oid;
	// 搭配 @IdClass 標註，bid 需要有 @Id
	@Id
	@Column(name = "bid")
	private Integer bid;

	@Column(name = "amount")
	private Integer amount;
	
	// 特別加上對複合主鍵物件的 getter / setter
	public CompositeDetail getCompositeKey() {
		return new CompositeDetail(oid, bid);
	}

	public void setCompositeKey(CompositeDetail key) {
		this.oid = key.getOid();
		this.bid = key.getBid();
	}
	
	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	// 需要宣告一個有包含複合主鍵屬性的類別，並一定要實作 java.io.Serializable 介面
	static class CompositeDetail implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer oid;
		private Integer bid;
		
		// 一定要有無參數建構子
		public CompositeDetail() {
			super();
		}

		public CompositeDetail(Integer oid, Integer bid) {
			super();
			this.oid = oid;
			this.bid = bid;
		}

		public Integer getOid() {
			return oid;
		}

		public void setOid(Integer oid) {
			this.oid = oid;
		}

		public Integer getBid() {
			return bid;
		}

		public void setBid(Integer bid) {
			this.bid = bid;
		}

		// 一定要 override 此類別的 hashCode() 與 equals() 方法！
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bid == null) ? 0 : bid.hashCode());
			result = prime * result + ((oid == null) ? 0 : oid.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;

			if (obj != null && getClass() == obj.getClass()) {
				CompositeDetail compositeKey = (CompositeDetail) obj;
				if (oid.equals(compositeKey.oid) && bid.equals(compositeKey.bid)) {
					return true;
				}
			}

			return false;
		}

	}

}

///////////////////////////////////////////////////////////////////////////

//@Entity
//@Table(name = "orderdetail2")
//public class OrderDetail2 {
//	// 直接宣告複合識別類別的屬性，並加上 @EmbeddedId 標註
//	@EmbeddedId
//	private CompositeDetail compositeKey;
//	
//	@Column(name = "amount")
//	private Integer amount;
//	
//	public CompositeDetail getCompositeKey() {
//		return compositeKey;
//	}
//
//	public void setCompositeKey(CompositeDetail compositeKey) {
//		this.compositeKey = compositeKey;
//	}
//
//	public Integer getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Integer amount) {
//		this.amount = amount;
//	}
//
//	// 需要宣告一個有包含複合主鍵屬性的類別，並一定實作 java.io.Serializable 介面
//	@Embeddable 
//	public static class CompositeDetail implements Serializable {
//		private static final long serialVersionUID = 1L;
//		@Column(name = "oid")
//		private Integer oid;
//		@Column(name = "bid")
//		private Integer bid;
//		
//		// 一定要有無參數建構子
//		public CompositeDetail() {
//			super();
//		}
//		
//		public CompositeDetail(Integer oid, Integer bid) {
//			super();
//			this.oid = oid;
//			this.bid = bid;
//		}
//
//		public Integer getOid() {
//			return oid;
//		}
//
//		public void setOid(Integer oid) {
//			this.oid = oid;
//		}
//
//		public Integer getBid() {
//			return bid;
//		}
//
//		public void setBid(Integer bid) {
//			this.bid = bid;
//		}
//
//		// 一定要 override 此類別的 hashCode() 與 equals() 方法！
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((bid == null) ? 0 : bid.hashCode());
//			result = prime * result + ((oid == null) ? 0 : oid.hashCode());
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//
//			if (obj != null && getClass() == obj.getClass()) {
//				CompositeDetail compositeKey = (CompositeDetail) obj;
//				if (oid.equals(compositeKey.oid) && bid.equals(compositeKey.bid)) {
//					return true;
//				}
//			}
//
//			return false;
//		}
//
//	}
//
//}
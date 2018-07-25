package it.polito.tdp.rivers.simulazione;


public class Event implements Comparable <Event>{   
		private double fOut;
		private int day;
		
		public Event(double flow, int day) {
			super();
			this.fOut = flow;
			this.day = day;
		}
		public double getFOut() {
			return fOut;
		}
		public int getDay() {
			return day;
		}
		@Override
		public int compareTo(Event other) {
			return this.day-other.day;
		}
		@Override
		public String toString() {
			return "Event [fOut=" + fOut + ", day=" + day + "]";
		}
		
	}

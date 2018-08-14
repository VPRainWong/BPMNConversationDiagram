package com.vp.plugin.sample.bpmnConversationPlugin;

import java.awt.Point;






import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IConversationDiagramUIModel;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.connector.IConversationLinkUIModel;
import com.vp.plugin.diagram.shape.IBPPoolUIModel;
import com.vp.plugin.diagram.shape.IConversationCommunicationUIModel;
import com.vp.plugin.diagram.shape.ISubConversationUIModel;
import com.vp.plugin.model.IBPParticipant;
import com.vp.plugin.model.IBPParticipantMultiplicity;
import com.vp.plugin.model.IBPPool;
import com.vp.plugin.model.IConversationCommunication;
import com.vp.plugin.model.IConversationLink;
import com.vp.plugin.model.ISubConversation;
import com.vp.plugin.model.factory.IModelElementFactory;

public class BpmnConversationAction implements VPActionController{

	@Override
	public void performAction(VPAction arg0) {
		//Create Blank BPMN Conversation Diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IConversationDiagramUIModel bpmnCon = (IConversationDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_CONVERSATION_DIAGRAM);
		bpmnCon.setName("Sample BPMN Conversation Diagram");
		
		//Create Participant(Pool)
		IBPPool retailer = IModelElementFactory.instance().createBPPool();
		retailer.setName("Retailer");
		//Create the Pool on the diagram
		IBPPoolUIModel shapeRetailer = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, retailer);
		shapeRetailer.setBounds(100, 100, 100, 150);
		//You will need to set the orientation or the pool will be 90 degree rotated
		shapeRetailer.setOrientation(IBPPoolUIModel.VERTICAL);
		//Turn auto stretch off
		shapeRetailer.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool supplier = IModelElementFactory.instance().createBPPool();
		supplier.setName("Supplier");
		IBPPoolUIModel shapeSupplier = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, supplier);
		shapeSupplier.setBounds(600, 100, 100, 150);
		shapeSupplier.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeSupplier.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool consignee = IModelElementFactory.instance().createBPPool();
		consignee.setName("Consignee");
		IBPPoolUIModel shapeConsignee = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, consignee);
		shapeConsignee.setBounds(300, 200, 200, 100);
		shapeConsignee.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeConsignee.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool consolidator = IModelElementFactory.instance().createBPPool();
		consolidator.setName("Consolidator");
		IBPPoolUIModel shapeConsolidator = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, consolidator);
		shapeConsolidator.setBounds(100, 400, 100, 50);
		shapeConsolidator.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeConsolidator.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool customsQuarantine = IModelElementFactory.instance().createBPPool();
		customsQuarantine.setName("Customs\n/Quarantine");
		IBPPoolUIModel shapeCustomsQuarantine = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, customsQuarantine);
		shapeCustomsQuarantine.setBounds(100, 550, 100, 50);
		shapeCustomsQuarantine.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeCustomsQuarantine.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool breakdownService = IModelElementFactory.instance().createBPPool();
		breakdownService.setName("Breakdown Servive");
		IBPPoolUIModel shapeBreakdownServive = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, breakdownService);
		shapeBreakdownServive.setBounds(100, 625, 100, 50);
		shapeBreakdownServive.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeBreakdownServive.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		//If the pool has participant, first set it up like a normal pool...
		IBPPool carrier = IModelElementFactory.instance().createBPPool();
		carrier.setName("Carrier \n (Land, Sea, Rail, or Air)");
		IBPParticipant carrierParticipant = IModelElementFactory.instance().createBPParticipant();
		//...Then set up the participant and multiplicity
		carrierParticipant.setName("Carrier Participant");
		IBPParticipantMultiplicity carrierParticipantMultiplicity = IModelElementFactory.instance().createBPParticipantMultiplicity();
		carrierParticipantMultiplicity.setName("Carrier Participant Multiplicity");
		carrierParticipant.setMultiplicity(carrierParticipantMultiplicity);
		carrier.setParticipant(carrierParticipant);
		//You can then visualize the pool
		IBPPoolUIModel shapeCarrier = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, carrier);
		shapeCarrier.setBounds(300, 400, 200, 200);
		shapeCarrier.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeCarrier.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool locativeService = IModelElementFactory.instance().createBPPool();
		locativeService.setName("Locative Service");
		IBPPoolUIModel shapeLocativeService = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, locativeService);
		shapeLocativeService.setBounds(600, 625, 100, 50);
		shapeLocativeService.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeLocativeService.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool insurance = IModelElementFactory.instance().createBPPool();
		insurance.setName("Insurance");
		IBPPoolUIModel shapeInsurance = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, insurance);
		shapeInsurance.setBounds(600, 550, 100, 50);
		shapeInsurance.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeInsurance.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		IBPPool shipper = IModelElementFactory.instance().createBPPool();
		shipper.setName("Shipper");
		IBPPoolUIModel shapeShipper = (IBPPoolUIModel) diagramManager.createDiagramElement(bpmnCon, shipper);
		shapeShipper.setBounds(600, 400, 100, 50);
		shapeShipper.setOrientation(IBPPoolUIModel.VERTICAL);
		shapeShipper.setAutoStretch(IBPPoolUIModel.AUTO_STRETCH_OFF);
		
		
		//Create  conversation link
		IConversationLink retailerToSupplier = IModelElementFactory.instance().createConversationLink();
		//This link is connecting from the retailer pool...
		retailerToSupplier.setFrom(retailer);
		//.. to the supplier pool
		retailerToSupplier.setTo(supplier);
		//create the connector on the diagram
		IConversationLinkUIModel shapeRetailerToSupplier = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, retailerToSupplier, shapeRetailer, shapeSupplier, new Point[] {new Point(200,150), new Point(600,150)});

		//Create a sub conversation
		ISubConversation deliveryNegotiation = IModelElementFactory.instance().createSubConversation();
		deliveryNegotiation.setConversationLink(retailerToSupplier);
		deliveryNegotiation.setName("Delivery Negotiations");
		//Create the sub conversation on the diagram
		ISubConversationUIModel shapeDeliveryNegotiation = (ISubConversationUIModel) diagramManager.createDiagramElement(bpmnCon, deliveryNegotiation);
		shapeDeliveryNegotiation.setBounds(385,138,30,24);
		shapeRetailerToSupplier.addChild(shapeDeliveryNegotiation);
		//Call to re-calculate caption position when render the diagram
		shapeDeliveryNegotiation.resetCaption();
		
		
		//Create a conversation link
		IConversationLink consigneeToRetailer = IModelElementFactory.instance().createConversationLink();
		//This link is connecting from the consignee pool...
		consigneeToRetailer.setFrom(consignee);
		//...to the retailer pool
		consigneeToRetailer.setTo(retailer);
		//create the connector on the diagram
		IConversationLinkUIModel shapeConsigneeToRetailer = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, consigneeToRetailer, shapeConsignee, shapeRetailer, new Point[] {new Point(300,225), new Point (200,225)});
		
		//Create a conversation
		IConversationCommunication deliveryDispatchPlan1 = IModelElementFactory.instance().createConversationCommunication();
		deliveryDispatchPlan1.setConversationLink(consigneeToRetailer);
		deliveryDispatchPlan1.setName("Delivery/Dispatch \nPlan");
		//Create the conversation on the diagram
		IConversationCommunicationUIModel shapeDeliveryDispatchPlan1 = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, deliveryDispatchPlan1);
		shapeDeliveryDispatchPlan1.setBounds(235, 213, 30, 24);
		shapeConsigneeToRetailer.addChild(shapeDeliveryDispatchPlan1);
		//Call to re-calculate caption position when render the diagram
		shapeDeliveryDispatchPlan1.resetCaption();
		
		
		IConversationLink consigneeToSupplier = IModelElementFactory.instance().createConversationLink();
		consigneeToSupplier.setFrom(consignee);
		consigneeToSupplier.setTo(supplier);
		IConversationLinkUIModel shapeConsigneeToSupplier = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, consigneeToSupplier, shapeConsignee, shapeSupplier, new Point [] {new Point (500,225), new Point (600,225)});
		
		IConversationCommunication shipmentSchedule = IModelElementFactory.instance().createConversationCommunication();
		shipmentSchedule.setConversationLink(consigneeToSupplier);
		shipmentSchedule.setName("Shipment Schedule");
		IConversationCommunicationUIModel shapeShipmentSchdule = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, shipmentSchedule);
		shapeShipmentSchdule.setBounds(535, 213, 30, 24);
		shapeConsigneeToSupplier.addChild(shapeShipmentSchdule);
		shapeShipmentSchdule.resetCaption();
		
		
		IConversationLink consolidatorToConsignee = IModelElementFactory.instance().createConversationLink();
		consolidatorToConsignee.setFrom(consolidator);
		consolidatorToConsignee.setTo(consignee);
		IConversationLinkUIModel shapeConsolidatorToConsignee = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, consolidatorToConsignee, shapeConsolidator, shapeConsignee, new Point[] {new Point(150,400), new Point(150,275), new Point(300,275)});
		
		IConversationCommunication deliveryMonitoring = IModelElementFactory.instance().createConversationCommunication();
		deliveryMonitoring.setConversationLink(consigneeToSupplier);
		deliveryMonitoring.setName("Delvery \n Monitoring");
		IConversationCommunicationUIModel shapeDeliveryMonitoring = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, deliveryMonitoring);
		shapeDeliveryMonitoring.setBounds(135, 290, 30, 24);
		shapeConsolidatorToConsignee.addChild(shapeDeliveryMonitoring);
		shapeDeliveryMonitoring.resetCaption();

		
		IConversationLink consolidatorToCustoms = IModelElementFactory.instance().createConversationLink();
		consolidatorToCustoms.setFrom(consolidator);
		consolidatorToCustoms.setTo(customsQuarantine);
		IConversationLinkUIModel shapeConsolidatorToCustoms = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, consolidatorToCustoms, shapeConsolidator, shapeCustomsQuarantine, null);
		
		IConversationCommunication clearanceMnitoring = IModelElementFactory.instance().createConversationCommunication();
		clearanceMnitoring.setConversationLink(consolidatorToCustoms);
		clearanceMnitoring.setName("Clearance\nMonitoring");
		IConversationCommunicationUIModel shapeClearanceMonitoring = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, clearanceMnitoring);
		shapeClearanceMonitoring.setBounds(135, 488, 30, 24);
		shapeConsolidatorToCustoms.addChild(shapeClearanceMonitoring);
		shapeClearanceMonitoring.resetCaption();

		
		IConversationLink carrierToConsolidator = IModelElementFactory.instance().createConversationLink();
		carrierToConsolidator.setFrom(carrier);
		carrierToConsolidator.setTo(consolidator);
		IConversationLinkUIModel shapeCarrierToConsolidator = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToConsolidator, shapeCarrier, shapeConsolidator, new Point[] {new Point(300,425), new Point(200,425)});
		
		IConversationCommunication deliveryDispatchPlan2 = IModelElementFactory.instance().createConversationCommunication();
		deliveryDispatchPlan2.setConversationLink(carrierToConsolidator);
		deliveryDispatchPlan2.setName("Delivery/Dispatch \nPlan");
		IConversationCommunicationUIModel shapeDeliveryDispatchPlan2 = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, deliveryDispatchPlan2);
		shapeDeliveryDispatchPlan2.setBounds(235, 413, 30, 24);
		shapeCarrierToConsolidator.addChild(shapeDeliveryDispatchPlan2);
		shapeDeliveryDispatchPlan2.resetCaption();

		
		IConversationLink carrierToCustoms = IModelElementFactory.instance().createConversationLink();
		carrierToCustoms.setFrom(carrier);
		carrierToCustoms.setTo(customsQuarantine);
		IConversationLinkUIModel shapeCarrierToCustoms = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToCustoms, shapeCarrier, shapeCustomsQuarantine, new Point[] {new Point(300,575), new Point(200,575)});
		
		IConversationCommunication clearancePreNotification = IModelElementFactory.instance().createConversationCommunication();
		clearancePreNotification.setConversationLink(carrierToCustoms);
		clearancePreNotification.setName("Clearance Pre-\nNotification");
		IConversationCommunicationUIModel shapeCustomPreNotification = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, clearancePreNotification);
		shapeCustomPreNotification.setBounds(235, 563, 30, 24);
		shapeCarrierToCustoms.addChild(shapeCustomPreNotification);
		shapeCustomPreNotification.resetCaption();

		
		IConversationLink carrierToBreakdown = IModelElementFactory.instance().createConversationLink();
		carrierToBreakdown.setFrom(carrier);
		carrierToBreakdown.setTo(breakdownService);
		IConversationLinkUIModel shapeCarrierToBreakdown = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToBreakdown, shapeCarrier, shapeBreakdownServive, new Point[] {new Point(350,600), new Point(350,650), new Point(200,650)});
		
		IConversationCommunication truckBreakdownProvision = IModelElementFactory.instance().createConversationCommunication();
		truckBreakdownProvision.setConversationLink(carrierToBreakdown);
		truckBreakdownProvision.setName("Truck Breakdown \nProvision");
		IConversationCommunicationUIModel shapeTruckBreakdownProvision = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, truckBreakdownProvision);
		shapeTruckBreakdownProvision.setBounds(235, 638, 30, 24);
		shapeCarrierToBreakdown.addChild(shapeTruckBreakdownProvision);
		shapeTruckBreakdownProvision.resetCaption();

		
		IConversationLink carrierToCarrier = IModelElementFactory.instance().createConversationLink();
		carrierToCarrier.setFrom(carrier);
		carrierToCarrier.setTo(carrier);
		IConversationLinkUIModel shapeCarrierToCarrier = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToCarrier, shapeCarrier, shapeCarrier, new Point[] {new Point(375,600), new Point(375,650), new Point(425,650), new Point(425,600)});
		
		IConversationCommunication arivalPickUpConfirmation = IModelElementFactory.instance().createConversationCommunication();
		arivalPickUpConfirmation.setConversationLink(carrierToCarrier);
		arivalPickUpConfirmation.setName("Arrival/Piclkup \nConfirmation");
		IConversationCommunicationUIModel shapeArrivalPickupInformation = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, arivalPickUpConfirmation);
		shapeArrivalPickupInformation.setBounds(385, 638, 30, 24);
		shapeCarrierToCarrier.addChild(shapeArrivalPickupInformation);
		shapeArrivalPickupInformation.resetCaption();

		
		IConversationLink carrierToLocative = IModelElementFactory.instance().createConversationLink();
		carrierToLocative.setFrom(carrier);
		carrierToLocative.setTo(locativeService);
		IConversationLinkUIModel shapeCarrierToLocative = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToLocative, shapeCarrier, shapeLocativeService, new Point[] {new Point(450,600), new Point(450,650), new Point(600,650)});
		
		IConversationCommunication trafficOptimizationGuidance = IModelElementFactory.instance().createConversationCommunication();
		trafficOptimizationGuidance.setConversationLink(carrierToLocative);
		trafficOptimizationGuidance.setName("Traffic Optimization \nGuidance");
		IConversationCommunicationUIModel shapeTrafficOptimzationGuidance = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, trafficOptimizationGuidance);
		shapeTrafficOptimzationGuidance.setBounds(535, 638, 30, 24);
		shapeCarrierToLocative.addChild(shapeTrafficOptimzationGuidance);
		shapeTrafficOptimzationGuidance.resetCaption();

		
		IConversationLink carrierToInsurance = IModelElementFactory.instance().createConversationLink();
		carrierToInsurance.setFrom(carrier);
		carrierToInsurance.setTo(insurance);
		IConversationLinkUIModel shapeCarrierToInsurance= (IConversationLinkUIModel)diagramManager.createConnector(bpmnCon, carrierToInsurance, shapeCarrier, shapeInsurance, new Point[] {new Point(500,575), new Point(600,575)});
		
		IConversationCommunication coverageNotification = IModelElementFactory.instance().createConversationCommunication();
		coverageNotification.setConversationLink(carrierToInsurance);
		coverageNotification.setName("Coverage \nNotification");
		IConversationCommunicationUIModel shapeCoverageNotification = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, coverageNotification);
		shapeCoverageNotification.setBounds(535, 563, 30, 24);
		shapeCarrierToInsurance.addChild(shapeCoverageNotification);
		shapeCoverageNotification.resetCaption();

		
		IConversationLink carrierToShipper = IModelElementFactory.instance().createConversationLink();
		carrierToShipper.setFrom(carrier);
		carrierToShipper.setTo(shipper);
		IConversationLinkUIModel shapeCarrierToShipper = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, carrierToShipper, shapeCarrier, shapeShipper, new Point[] {new Point(500, 425), new Point(600,425)});
		
		IConversationCommunication carrierPlanning = IModelElementFactory.instance().createConversationCommunication();
		carrierPlanning.setConversationLink(carrierToShipper);
		carrierPlanning.setName("Carrier Planning");
		IConversationCommunicationUIModel shapeCarrierPlaning = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, carrierPlanning);
		shapeCarrierPlaning.setBounds(535, 413, 30, 24);
		shapeCarrierToShipper.addChild(shapeCarrierPlaning);
		shapeCarrierPlaning.resetCaption();

		
		IConversationLink shipperToInsurance = IModelElementFactory.instance().createConversationLink();
		shipperToInsurance.setFrom(shipper);
		shipperToInsurance.setTo(insurance);
		IConversationLinkUIModel shapeShipperToInsurance = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, shipperToInsurance, shapeShipper, shapeInsurance, null);
		
		IConversationCommunication noName = IModelElementFactory.instance().createConversationCommunication();
		noName.setConversationLink(shipperToInsurance);
		IConversationCommunicationUIModel shapeNoName = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, noName);
		shapeNoName.setBounds(635, 488, 30, 24);
		shapeShipperToInsurance.addChild(shapeNoName);
		
		IConversationLink shipperToSupplier = IModelElementFactory.instance().createConversationLink();
		shipperToSupplier.setFrom(shipper);
		shipperToSupplier.setTo(supplier);
		IConversationLinkUIModel shapeShipperToSupplier = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, shipperToSupplier, shapeShipper, shapeSupplier, null);
		
		IConversationCommunication deliveryPlanning = IModelElementFactory.instance().createConversationCommunication();
		deliveryPlanning.setConversationLink(shipperToSupplier);
		deliveryPlanning.setName("deliveryPlanning");
		IConversationCommunicationUIModel shapeDiliveryPlanning = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, deliveryPlanning);
		shapeDiliveryPlanning.setBounds(635, 290, 30, 24);
		shapeShipperToSupplier.addChild(shapeDiliveryPlanning);
		shapeDiliveryPlanning.resetCaption();
		
		//If a conversation link is connecting to more than two pools, first make a conversation link between two of pools
		IConversationLink consolidatorToShipper = IModelElementFactory.instance().createConversationLink();
		consolidatorToShipper.setFrom(consolidator);
		consolidatorToShipper.setTo(shipper);
		IConversationLinkUIModel shapeConsolidatorToShipper = (IConversationLinkUIModel) diagramManager.createConnector(bpmnCon, consolidatorToShipper, shapeConsolidator, shapeShipper, new Point[] {new Point(175,400), new Point(175,350), new Point(625,350), new Point(625,400)});
		//Then create a conversation
		IConversationCommunication detailedShipmentSchedule = IModelElementFactory.instance().createConversationCommunication();
		detailedShipmentSchedule.setConversationLink(consolidatorToShipper);
		detailedShipmentSchedule.setName("Detailed Shipment \n Schedule");
		IConversationCommunicationUIModel shapeDetailedShipmentSchedule = (IConversationCommunicationUIModel) diagramManager.createDiagramElement(bpmnCon, detailedShipmentSchedule);
		shapeDetailedShipmentSchedule.setBounds(385, 338, 30, 24);
		shapeConsolidatorToShipper.addChild(shapeDetailedShipmentSchedule);
		shapeDetailedShipmentSchedule.resetCaption();
		//Finally, create a conversation link between the remaining pools and the conversation
		IConversationLink consigneeToDetailShipmentSchedule = IModelElementFactory.instance().createConversationLink();
		consigneeToDetailShipmentSchedule.setFrom(consignee);
		consigneeToDetailShipmentSchedule.setTo(detailedShipmentSchedule);
		diagramManager.createConnector(bpmnCon, consigneeToDetailShipmentSchedule, shapeConsignee, shapeDetailedShipmentSchedule, new Point[] {new Point(400,300), new Point(400,338)});

		
		//Show diagram
		diagramManager.openDiagram(bpmnCon);
		
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}

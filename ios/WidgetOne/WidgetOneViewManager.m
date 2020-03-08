//
//  WidgetOneViewManager.m
//  NativeComp
//
//  Created by adrian.hartanto on 26/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "WidgetOneViewManager.h"
#import "WidgetOneViewController.h"
#import <React/RCTUIManager.h>

@interface WidgetOneViewManager ()
@property (strong, nonatomic) NSMutableDictionary *widgetDict;
@end

@implementation WidgetOneViewManager

RCT_EXPORT_MODULE(WidgetOne)

- (NSMutableDictionary *)widgetDict {
  if (!_widgetDict) {
    _widgetDict = [NSMutableDictionary new];
  }
  
  return _widgetDict;
}

- (UIView *)view {
  WidgetOneViewController *widget = [[WidgetOneViewController alloc] initWithVM: self];
  [self.widgetDict setValue:widget forKey:widget.description];

  return widget.view;
}

+ (BOOL)requiresMainQueueSetup {
  return NO;
}

- (void)setSizeForView:(UIView *)view size:(CGSize)size {
  [self.bridge.uiManager setSize:size forView:view];
}

- (dispatch_queue_t)methodQueue {
  return dispatch_get_main_queue();
}

@end
